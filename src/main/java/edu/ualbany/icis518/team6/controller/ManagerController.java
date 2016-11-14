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
import edu.ualbany.icis518.team6.Projects;

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
			return "/project";
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
		return "addProject";
	}
	
	@PostMapping("/project")
	public String createProject(@RequestBody MultiValueMap<String,String> formData, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
//		System.out.println(formData);
		Projects newProject = new Projects();
		newProject.setProjectManager(employee);
		newProject.setBudget(Integer.parseInt(formData.getFirst("budget")));
		newProject.setProjectName(formData.getFirst("name"));
		newProject.save();
		return "redirect:/manager";
	}
	
	@GetMapping("/trip/new")
	public String newTrip(HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		return "add_trip";
	}
	
	@PostMapping("/trip")
	public String createTrip(HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		if (!employee.getRole().equalsIgnoreCase("manager")) {
			return "redirect:/employee";
		}
		//create project and redirect user
		return "redirect:/manager";
	}
}