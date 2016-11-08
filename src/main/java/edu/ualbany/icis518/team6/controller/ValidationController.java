package edu.ualbany.icis518.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Employee;

@Controller
public class ValidationController {

	/*
	 * This method validates employee and redirect to landing page based on the role of employee.
	 */
	@RequestMapping(value = "/login")
	public String validateEmployee(@RequestParam(value="userName") int employeeId, 
				@RequestParam(value="password") String password, Model model) {
		
		Employee emp = new Employee().getbyEmployeeId(employeeId);
		String view = "redirect:/";
		
		if((employeeId == emp.getEmployeeId()) && (password.trim().equals(emp.getPassword()))){
			if(emp.getRole().equals("Manager"))
				view += "manager";
			else if(emp.getRole().equals("HR"))
				view += "hr";
			else
				view += "employee?id=" + emp.getEmployeeId();
		}
		
		model.addAttribute("empId", employeeId);
		return view;		
	}
	
	@RequestMapping("/")
	public String homePage() {
		return "login";
	}
}
