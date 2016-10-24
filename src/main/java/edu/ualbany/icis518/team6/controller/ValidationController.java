package edu.ualbany.icis518.team6.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import edu.ualbany.icis518.team6.Employee;

@Controller
public class ValidationController {

	@RequestMapping(value = "/login")
	public ModelAndView validateEmployee(final HttpServletRequest request, final HttpServletResponse response) {
		
		final String employeeId = request.getParameter("userName");
		final String password = request.getParameter("password");

		WebApplicationContext appContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getSession().getServletContext());
		
		System.out.println(employeeId + " = " + password ); 
		
		Employee emp = (Employee)appContext.getBean("Employee");
		String view = null;
		
		if(employeeId.trim().equals(emp.getEmployeeId())){
			if(password.trim().equals(emp.getPassword()) && emp.getRole().equals("Manager"))
					view = "manager";
				else if(emp.getRole().equals("HR"))
					view = "HR";
				else
					view = "employee";
			}
		
		request.setAttribute("name", employeeId);
		return new ModelAndView(view);
		
	}
}
