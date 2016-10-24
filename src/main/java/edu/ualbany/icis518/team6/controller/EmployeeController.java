package edu.ualbany.icis518.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
	
	@RequestMapping("/employee")
	public String employeeHomePage() {
		return "employee";
	}

	@RequestMapping("/employee/trip")
	public String trip() {
		return "employee_form";
	}
	
	@RequestMapping("/employee/receipts")
	public String showReceipt() {
		return "show_receipts";
	}
}
