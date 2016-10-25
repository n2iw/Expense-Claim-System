package edu.ualbany.icis518.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
	
	@RequestMapping("/manager")
	public String managerHomePage() {
		return "manager";
	}

	@RequestMapping("/manager/project")
	public String showProject() {
		return "project_details";
	}

	@RequestMapping("/manager/project/new")
	public String newProject() {
		return "addProject";
	}
	
	@RequestMapping("/manager/project/create")
	public String createProject() {
		//create project and redirect user
		return "redirect:/manager/project";
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