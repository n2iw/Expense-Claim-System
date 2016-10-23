package edu.ualbany.icis518.team6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@Autowired
	private EmployeeRepository employees;
	
	@RequestMapping("/")
	@ResponseBody
	public String test() {
		Employee e = null;
		if (e == null) {
			System.out.println("Create a new Employee!");
			e = new Employee();
			e.setFirstName("Mike");
			employees.save(e);
		} else {
			System.out.println("Employee 0 exists!");
		}

		return "Hello " + e.getFirstName() + "!";
	}
}
