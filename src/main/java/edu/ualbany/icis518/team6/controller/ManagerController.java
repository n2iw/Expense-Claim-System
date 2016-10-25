package edu.ualbany.icis518.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.Projects;

import java.util.List;

@Controller
public class ManagerController {
	
	@RequestMapping("/manager")
	public String managerHomePage(@RequestParam(value="id", defaultValue="1") int id,
			Model model) {
		Employee e = Employee.getbyEmployeeId(id);
		List<Projects> projects = Projects.getbyProjectManager(e);
		model.addAttribute("projects", projects);
		return "manager";
	}

	@RequestMapping("/manager/project")
	public String showProject(@RequestParam(value="id", required=true) int id,
			Model model) {
		Projects project = Projects.getbyProjectId(id);
		model.addAttribute("project", project);
		return "project_details";
	}

	@RequestMapping("/manager/project/new")
	public String newProject() {
		return "addProject";
	}
	
	@RequestMapping("/manager/project/create")
	public String createProject() {
		//create project and redirect user
		return "redirect:/manager/project?id=1";
	}
	
	@RequestMapping("/manager/trip/new")
	public String newTrip() {
		return "add_trip";
	}
	
	@RequestMapping("/manager/trip/create")
	public String createTrip() {
		//create project and redirect user
		return "redirect:/manager";
	}
}