package edu.ualbany.icis518.team6.controller;

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
import edu.ualbany.icis518.team6.EmployeeTrips;
import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Projects;
import edu.ualbany.icis518.team6.Trips;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
	
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
		model.addAttribute("project", project);
		return "project_details";
//		return "addProject";
	}
	
	@PostMapping("/project")
	public String updateProject(@RequestBody MultiValueMap<String,String> formData, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
//		System.out.println(formData);
		int projectId = Integer.parseInt(formData.getFirst("projectId"));
		Projects project = Projects.getbyProjectId(projectId);
		if ( project == null) {
			project = new Projects();
		}
		project.setProjectManager(employee);
		project.setBudget(Integer.parseInt(formData.getFirst("budget")));
		project.setProjectName(formData.getFirst("name"));
		project.save();
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
			//TODO: delete all related EmployeeTrips record
			for (Trips trip: Trips.getbyProject(project)) {
				for (EmployeeTrips et: EmployeeTrips.getbyTrip(trip)) {
					et.delete();
				}
				for (Expense exp: Expense.getbyTrip(trip)) {
					exp.delete();
				}
				trip.delete();
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
		model.addAttribute("trip", trip);
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
		Trips trip = new Trips();
		trip.setProj(project);
		trip.setDescription("");
		trip.setStartDate(new Date());
		trip.setEndDate(new Date());
		model.addAttribute("trip", trip);
		return "trip_detail";
	}
	
	@PostMapping("/trip")
	public String createTrip(@RequestBody MultiValueMap<String,String> formData, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
//		System.out.println(formData);
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
		trip.setStartDate(trip.StringToDate(formData.getFirst("startDate")));
		trip.setEndDate(trip.StringToDate(formData.getFirst("endDate")));
		trip.save();
		for (String employeeIdString: formData.get("employeeId")) {
			Employee emp = Employee.getbyEmployeeId(Integer.parseInt(employeeIdString));
			if (emp == null) {
				continue;
			}
			trip.setEmployee(emp);
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

		for (EmployeeTrips et: EmployeeTrips.getbyTrip(trip)) {
			et.delete();
		}
		
		for (Expense exp: Expense.getbyTrip(trip)) {
			exp.delete();
		}

		trip.delete();
		if (project == null) {
			return "redirect:/manager";
		}
		return "redirect:/project/" + project.getProjectId();
	}
}