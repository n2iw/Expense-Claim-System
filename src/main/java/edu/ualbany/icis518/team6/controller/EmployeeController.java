package edu.ualbany.icis518.team6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Trips;
import edu.ualbany.icis518.team6.util.StorageService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final StorageService storageService;
    private final String receiptPrefix = "receipt_";

   @Autowired
	public EmployeeController(StorageService storageService) {
		this.storageService = storageService;
	}

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
		List<Expense> allExps = Expense.getbyEmployeeAndTrip(employee, trip);
		List<Expense> exps = new ArrayList<>();
		List<Expense> readonlyExps = new ArrayList<>();
		for (Expense exp : allExps) {
			if (exp.getdeleted()) {
				continue;
			}
			switch(exp.getStatus().toLowerCase()) {
			case "saved":
			case "declined":
				exps.add(exp);
				break;
			case "submitted":
			case "approved":
				readonlyExps.add(exp);
				break;
			default:
				System.out.println("Wrong Expense status: " + exp.getStatus());
			}
		}

		model.addAttribute("expenses", exps);
		model.addAttribute("readonlyExpenses", readonlyExps);
		model.addAttribute("trip", trip);
		return "employee_form";
	}
	
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
		exp.setType("Food");
		model.addAttribute("trip", trip);
		model.addAttribute("expense", exp);
		return "expense_form";
	}

	@GetMapping("/expense/{expenseId}/edit")
	public String editExpense( @PathVariable int expenseId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		Expense exp = Expense.getbyExpenseId(expenseId);
		if (exp == null) {
			return "redirect:/employee";	
		}
		Trips trip = exp.getTrip();
		model.addAttribute("trip", trip);
		model.addAttribute("expense", exp);
		return "expense_form";
	}
	
	@PostMapping("/expense")
	public String saveExpense(
			@RequestParam int tripId,
			@RequestParam int expenseId,
			@RequestParam int amount,
			@RequestParam String type,
			@RequestParam String notes,
			@RequestPart(name="receipt", required=false) Part file, 
			HttpSession session,
			Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
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
		exp.setAmount(amount);
		exp.setType(type);
		exp.setEmp_notes(notes);
		exp.save(); //Save to get id
		if (file != null && file.getSize() > 0) {
			if (exp.getReceipt() != null && !exp.getReceipt().isEmpty()) {
				storageService.delete(exp.getReceipt());
			}
			storageService.store(file, receiptPrefix + exp.getExpenseId());
			exp.setReceipt(storageService.getStoredPublicPath(file, receiptPrefix + exp.getExpenseId()));
		}
		exp.setdeleted(false);
		exp.setStatus("Saved");
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

	@GetMapping("/expense/{expenseId}/delete_receipt")
	public String deleteReceipt(@PathVariable int expenseId, HttpSession session, Model model) {
		Employee employee = getEmployee(session);
		if (employee == null) {
			return "redirect:/";
		}
		Expense exp = Expense.getbyExpenseId(expenseId);
		if (exp == null) {
			return "redirect:/employee";	
		}
		
		System.out.println("Delete receipt: " + exp.getReceipt());
		storageService.delete(exp.getReceipt());

		exp.setReceipt("");
		exp.save();
		return "redirect:/employee/expense/" + exp.getExpenseId() + "/edit";	
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
		exp.setStatus("Submitted");
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
			model.addAttribute("receipt", exp.getReceipt());
			model.addAttribute("expense", exp);
		}
		return "show_receipts";
	}
}
