package edu.ualbany.icis518.team6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Trips;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private Employee getEmployee(HttpSession session, int id) {
		Employee e;
		Object obj = session.getAttribute("employee");
		if (obj != null && obj instanceof Employee) {
			e = (Employee)obj;
		} else {
			e = Employee.getbyEmployeeId(id);
			session.setAttribute("employee", e);
		}
		return e;
	}	

	@GetMapping(value={"/trip", ""})
	public String employeeHomePage( HttpSession session, Model model) {
		Employee e = getEmployee(session, 1);
		List<Trips> trips = e.getAllMyTrips();
		model.addAttribute("trips", trips);
		return "employee";
	}

	@GetMapping("/trip/{tripId}")
	public String showTrip(@PathVariable int tripId, HttpSession session, Model model) {
		Employee e = getEmployee(session, 1);
		Trips trip = Trips.getbyTripId(tripId);
		List<Expense> exps = Expense.getbyEmployeeAndTrip(e, trip);

		model.addAttribute("expenses", exps);
		model.addAttribute("project", trip.getProj());
		model.addAttribute("trip", trip);
		return "employee_form";
	}
	
	@GetMapping("/expense/{expenseId}")
	public String showExpense(@PathVariable int expenseId, HttpSession session, Model model) {
		Expense e = Expense.getbyExpenseId(expenseId);
		model.addAttribute("expense", e);
	    return "expense";	
	}
	
	@PostMapping("/expense")
	public String createExpense(@ModelAttribute Expense exp, HttpSession session, Model model) {
		exp.save();
		return "redirect:/employee/trip/" + exp.getTrip().getTripId();
	}
	
	@GetMapping("/expense/{expenseId}/delete")
	public String deleteExpense(@PathVariable int expenseId, HttpSession session, Model model) {
		Expense e = Expense.getbyExpenseId(expenseId);
		e.delete();
	    return "expense";	
	}

	@GetMapping("/expense/{expenseId}/submit")
	public String submitExpense(@PathVariable int expenseId, HttpSession session, Model model) {
		Expense e = Expense.getbyExpenseId(expenseId);
		e.setStatus("submitted");
		e.save();
	    return "expense";	
	}
		
	@GetMapping("/expense/new")
	public String newExpense( @RequestParam int tripId, HttpSession session, Model model) {
		Trips trip = Trips.getbyTripId(tripId);
		model.addAttribute("project", trip.getProj());
		model.addAttribute("trip", trip);
		return "add_expense";
	}


	
	@GetMapping("/trip/{tripId}/receipts")
	public String showReceipts( @PathVariable int tripId, HttpSession session, Model model) {
		return "show_receipts";
	}
}
