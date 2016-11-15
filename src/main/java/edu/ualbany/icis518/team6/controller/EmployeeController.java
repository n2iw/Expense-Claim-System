package edu.ualbany.icis518.team6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Projects;
import edu.ualbany.icis518.team6.Trips;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private Employee getEmployee(HttpSession session) {
		Employee e = null;
		Object obj = session.getAttribute("employee");
		if (obj != null && obj instanceof Employee) {
			e = (Employee)obj;
		} 
		return e;
	}	

	@GetMapping(value={"/trip", ""})
	public String employeeHomePage( HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		List<Trips> trips = employee.getAllMyTrips();
		model.addAttribute("trips", trips);
		return "employee";
	}

	@GetMapping("/trip/{tripId}")
	public String showTrip(@PathVariable int tripId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		Trips trip = Trips.getbyTripId(tripId);
		List<Expense> exps = Expense.getbyEmployeeAndTrip(employee, trip);

		model.addAttribute("expenses", exps);
		model.addAttribute("trip", trip);
		return "employee_form";
	}
	
//	@GetMapping("/expense/{expenseId}")
//	public String showExpense(@PathVariable int expenseId, HttpSession session, Model model) {
//		Expense e = Expense.getbyExpenseId(expenseId);
//		model.addAttribute("expense", e);
//	    return "expense";	
//	}
		
	@GetMapping("/expense/new")
	public String newExpense( @RequestParam int tripId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		Trips trip = Trips.getbyTripId(tripId);
		if (trip == null) {
			return "redirect:/employee";
		}
		Expense exp = new Expense();
		exp.setEmpl(employee);
		exp.setTrip(trip);
		model.addAttribute("trip", trip);
		model.addAttribute("expense", exp);
		return "add_expense";
	}
	
	@PostMapping("/expense")
	public String saveExpense(@RequestBody MultiValueMap<String,String> formData, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		int tripId = Integer.parseInt(formData.getFirst("tripId"));
		int expenseId = Integer.parseInt(formData.getFirst("expenseId"));
		Trips trip = Trips.getbyTripId(tripId);
		if ( trip == null) {
			return "redirect:/employee";
		}
		Expense exp = Expense.getbyExpenseId(expenseId);
		if (exp == null) {
			exp = new Expense();
		}
		exp.setTrip(trip);
		exp.setEmpl(employee);
		exp.setAmount(Integer.parseInt(formData.getFirst("amount")));
		exp.setType(formData.getFirst("type"));
		exp.setReceipt(formData.getFirst("receipt"));
		exp.setdeleted(false);
		if (exp.getStatus() == null) {
			exp.setStatus("saved");
		}
		exp.save();
		return "redirect:/employee/trip/" + trip.getTripId();
	}
	
	@GetMapping("/expense/{expenseId}/delete")
	public String deleteExpense(@PathVariable int expenseId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		Expense exp = Expense.getbyExpenseId(expenseId);
		if (exp == null) {
			return "redirect:/employee";	
		}
		exp.setdeleted(true);
		exp.save();
		return "redirect:/employee/trip/" + exp.getTrip().getTripId();	
	}

	@GetMapping("/expense/{expenseId}/submit")
	public String submitExpense(@PathVariable int expenseId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		Expense exp = Expense.getbyExpenseId(expenseId);
		if (exp == null) {
			return "redirect:/employee";	
		}
		exp.setStatus("submitted");
		exp.save();
		return "redirect:/employee/trip/" + exp.getTrip().getTripId();	
	}

	@GetMapping("/expense/{expenseId}/receipts")
	public String showReceipts( @PathVariable int expenseId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		Expense exp = Expense.getbyExpenseId(expenseId);
		if (exp != null) {
			model.addAttribute("receip", exp.getReceipt());
		}
		return "show_receipts";
	}
}
