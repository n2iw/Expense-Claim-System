package edu.ualbany.icis518.team6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.EmployeeProjects;
import edu.ualbany.icis518.team6.EmployeeTrips;
import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Projects;
import edu.ualbany.icis518.team6.Trips;
import edu.ualbany.icis518.team6.util.StorageService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
    private final StorageService storageService;
    private final String receiptPrefix = "receipt_";

   @Autowired
	public ManagerController(StorageService storageService) {
		this.storageService = storageService;
	}

	private Employee getEmployee(HttpSession session) {
		Employee e = null;
		Object obj = session.getAttribute("employee");
		if (obj != null && obj instanceof Employee) {
			e = (Employee)obj;
		} 
		return e;
	}	
	
	@GetMapping(value={"/manager", "/project"})
	public String managerHomePage(HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		List<Projects> projects = Projects.getbyProjectManager(employee);
		model.addAttribute("projects", projects);
		return "manager";
	}

	@GetMapping("/project/{projectId}")
	public String showProject( @PathVariable int projectId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		Projects project = Projects.getbyProjectId(projectId);
		if (project == null) {
			System.out.println("ManagerController: project not found for id=" + projectId);
			return "redirect:/manager";
		}
		// Not my project
		if (project.getProjectManager().getEmployeeId() != employee.getEmployeeId()) {
			return "redirect:/manager";
		}
		List<Employee> emps = Employee.getAllEmployee();
		model.addAttribute("emps", emps);
		List<Integer> currentEmpIds = new ArrayList<>();
		for (Employee e : project.getAllEmployeeOfThisProject()) {
			currentEmpIds.add(e.getEmployeeId());
		}
		model.addAttribute("currentEmpIds", currentEmpIds);
		model.addAttribute("project", project);
		return "project_details";
	}

	@GetMapping("/project/new")
	public String newProject(HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		Projects project = new Projects();
		project.setProjectName("");
		List<Employee> emps = Employee.getAllEmployee();
		model.addAttribute("project", project);
		model.addAttribute("emps", emps);
		model.addAttribute("currentEmpIds", new ArrayList<Integer>());
		return "project_details";
	}
	
	@PostMapping("/project")
	public String saveProject(@RequestBody MultiValueMap<String,String> formData, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		int projectId = Integer.parseInt(formData.getFirst("projectId"));
		Projects project = Projects.getbyProjectId(projectId);
		if ( project == null) {
			project = new Projects();
		}
		project.setProjectManager(employee);
		project.setProjectName(formData.getFirst("name"));
		
		List<String> errors = new ArrayList<String>();
		//Validate Budget
		try {
			int expense = project.getBudget() - project.getCurrentBudget();
			project.setBudget(Integer.parseInt(formData.getFirst("budget")));
			project.setCurrentBudget(project.getBudget() - expense);
			if (project.getBudget() <= 0) {
				errors.add("Budget must be greater than 0!");
			}
		} catch (NumberFormatException nfe){
			errors.add("Budget must be an integer!");
		}
		//Validate Name
		if (project.getProjectName() == null || project.getProjectName().isEmpty()) {
			errors.add("Project Name can't be empty!");
		}


		//Validation failed
		if (!errors.isEmpty()) {
			List<Integer> currentEmpIds = new ArrayList<>();
			for (Employee e : project.getAllEmployeeOfThisProject()) {
				currentEmpIds.add(e.getEmployeeId());
			}
			List<Employee> emps = Employee.getAllEmployee();
			model.addAttribute("error", String.join("<br>", errors));
			model.addAttribute("project", project);
			model.addAttribute("currentEmpIds", currentEmpIds);
			model.addAttribute("emps", emps);
			return "project_details";
		}
		
		project.save();
		
		//Update employee project relationship
		for (EmployeeProjects ep: EmployeeProjects.getbyProject(project)) {
			ep.delete();
		}
		List<String> employeeIds = formData.get("employeeIds");
		if (employeeIds != null) {
			for (String employeeIdString: employeeIds ) {
				Employee emp = Employee.getbyEmployeeId(Integer.parseInt(employeeIdString));
				if (emp == null) {
					continue;
				}
				project.setEmployee(emp);
			}
		}
		return "redirect:/project/" + project.getProjectId();
	}

	@GetMapping("/project/{projectId}/delete")
	public String deleteProject(@PathVariable int projectId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		Projects project = Projects.getbyProjectId(projectId);
		if (project != null) {
			for (Trips trip: Trips.getbyProject(project)) {
				for (Expense exp: Expense.getbyTrip(trip)) {
					storageService.delete(exp.getReceipt());;
				}
			}
			project.delete();
		}
		return "redirect:/manager";
	}
	
	@GetMapping("/trip/{tripId}")
	public String showTrip( @PathVariable int tripId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		Trips trip = Trips.getbyTripId(tripId);
		if (trip == null) {
			System.out.println("ManagerController: trip not found for id=" + tripId);
			return "redirect:/manager";
		}

		List<Employee> emps = trip.getProj().getAllEmployeeOfThisProject();
		List<Integer> currentEmpIds = new ArrayList<>();
		model.addAttribute("trip", trip);
		model.addAttribute("employees", emps);
		for (Employee e : trip.getAllEmployeeOfThisTrip()) {
			currentEmpIds.add(e.getEmployeeId());
		}
		model.addAttribute("currentEmpIds", currentEmpIds);
		return "trip_detail";
	}

	@GetMapping("/trip/new")
	public String newTrip(@RequestParam int projectId ,HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		Projects project = Projects.getbyProjectId(projectId);
		if (project == null) {
			return "redirect:/manager";
		}
		List<Employee> emps = project.getAllEmployeeOfThisProject();
		Trips trip = new Trips();
		trip.setProj(project);
		trip.setDescription("");
		trip.setStartDate(new Date());
		trip.setEndDate(new Date());
		model.addAttribute("trip", trip);
		model.addAttribute("employees", emps);
		model.addAttribute("currentEmpIds", new ArrayList<Integer>());
		return "trip_detail";
	}
	
	@PostMapping("/trip")
	public String saveTrip(@RequestBody MultiValueMap<String,String> formData, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		int projectId = Integer.parseInt(formData.getFirst("projectId"));
		Projects project = Projects.getbyProjectId(projectId);
		if (project == null) {
			return "redirect:/manager";
		}
		int tripId = Integer.parseInt(formData.getFirst("tripId"));
		Trips trip = Trips.getbyTripId(tripId);
		if ( trip == null) {
			trip = new Trips();
		}
		trip.setProj(project);
		trip.setDescription(formData.getFirst("description"));
	    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 

		List<String> errors = new ArrayList<String>();
		//Validate Dates
		try {
			trip.setStartDate(sdf.parse(formData.getFirst("startDate")));
		} catch (ParseException e) {
			errors.add("Wrong date format for startDate! Please use format mm-dd-yyyy");
			trip.setStartDate(new Date());
		} catch (NullPointerException ne)  {
			errors.add("Start date is required!");
			trip.setStartDate(new Date());
		}
		try {
			trip.setEndDate(sdf.parse(formData.getFirst("endDate")));
		} catch (ParseException e) {
			errors.add("Wrong date format for endDate! Please use format mm-dd-yyyy");
			trip.setEndDate(new Date());
		} catch (NullPointerException ne)  {
			errors.add("End date is required!");
			trip.setEndDate(new Date());
		}

		//Validate Description
		if (trip.getDescription() == null || trip.getDescription().isEmpty()) {
			errors.add("Trip Description can't be empty!");
		}

		//Validation failed
		if (!errors.isEmpty()) {
			List<Employee> emps = trip.getProj().getAllEmployeeOfThisProject();
			List<Integer> currentEmpIds = new ArrayList<>();
			model.addAttribute("trip", trip);
			model.addAttribute("employees", emps);
			for (Employee e : trip.getAllEmployeeOfThisTrip()) {
				currentEmpIds.add(e.getEmployeeId());
			}
			model.addAttribute("currentEmpIds", currentEmpIds);
			model.addAttribute("error", String.join("<br>", errors));
			return "trip_detail";
		}

		trip.save();

		//Update employee trip relationship
		for (EmployeeTrips et: EmployeeTrips.getbyTrip(trip)) {
			et.delete();
		}
		List<String> employeeIds = formData.get("employeeIds");
		if (employeeIds != null) {
			for (String employeeIdString: formData.get("employeeIds")) {
				Employee emp = Employee.getbyEmployeeId(Integer.parseInt(employeeIdString));
				if (emp == null) {
					continue;
				}
				trip.setEmployee(emp);
			}
		}
		return "redirect:/project/" + project.getProjectId();
	}

	@GetMapping("/trip/{tripId}/delete")
	public String deleteTrip( @PathVariable int tripId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		Trips trip = Trips.getbyTripId(tripId);
		if (trip == null) {
			System.out.println("ManagerController: trip not found for id=" + tripId);
			return "redirect:/manager";
		}
		Projects project = trip.getProj();

		for (Expense exp: Expense.getbyTrip(trip)) {
			storageService.delete(exp.getReceipt());;
		}
		
		trip.delete();
		if (project == null) {
			return "redirect:/manager";
		}
		return "redirect:/project/" + project.getProjectId();
	}
}