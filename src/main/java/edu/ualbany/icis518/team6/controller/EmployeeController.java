package edu.ualbany.icis518.team6.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Trips;

@Controller
public class EmployeeController {
	
	@RequestMapping("/employee")
	public String employeeHomePage(@RequestParam(value="id", defaultValue="1") int id,
			Model model) {
		Employee e = Employee.getbyEmployeeId(id);
		List<Trips> trips = e.getAllMyTrips();
		model.addAttribute("trips", trips);
		model.addAttribute("id", id);
		return "employee";
	}

	@RequestMapping("/employee/trip")
	public String showTrip(@RequestParam(value="id", required=true) int id,
			@RequestParam(value="tripId", required=true) int tripId,
			Model model) {
		Employee e = Employee.getbyEmployeeId(id);
		Trips trip = Trips.getbyTripId(tripId);
		List<Expense> exps =  e.getAllMyExpense();
		//Ask jinlai to add find 
		model.addAttribute("expenses", exps);
		model.addAttribute("project", trip.getProj());
		model.addAttribute("trip", trip);
		return "employee_form";
	}
	
	@RequestMapping("/employee/receipts")
	public String showReceipts() {
		return "show_receipts";
	}
}
