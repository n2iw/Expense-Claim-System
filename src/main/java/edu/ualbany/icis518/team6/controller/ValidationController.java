package edu.ualbany.icis518.team6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.util.GenerateEncodedPassword;

@Controller
public class ValidationController {

	/*
	 * This method validates employee and redirect to landing page based on the role of employee.
	 */
	@Autowired 
	private WebApplicationContext context;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/login")
	public String validateEmployee(@RequestParam(value="userName") int employeeId, 
				@RequestParam(value="password") String password, Model model) {
			
		Employee emp = new Employee().getbyEmployeeId(employeeId);
		//GenerateEncodedPassword encodePwd = (GenerateEncodedPassword)context.getBean(GenerateEncodedPassword.class);
		//String encodedPassword = encodePwd.getEncodedPassword(password);
		String encodedPassword = password;
		String view = "redirect:/";
		
		if(emp == null){
			model.addAttribute("error", "Invalid User Name");
			return "login";
		}else if(encodedPassword.trim().equals(emp.getPassword())){
			if(emp.getRole().equalsIgnoreCase("manager"))
				view += "manager";
			else if(emp.getRole().equalsIgnoreCase("HR"))
				view += "hr";
			else
				view += "employee?id=" + emp.getEmployeeId();
			
			session.setAttribute("employee", emp);
		}else{
			model.addAttribute("error", "Invalid Password");
			return "login";
		}
		return view;		
	}
	
	@RequestMapping("/")
	public String homePage() {
		session.invalidate();
		return "login";
	}
}
