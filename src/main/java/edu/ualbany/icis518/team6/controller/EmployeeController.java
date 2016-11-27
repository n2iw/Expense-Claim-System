package edu.ualbany.icis518.team6.controller;

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
	public String saveExpense(
			@RequestParam int tripId,
			@RequestParam int expenseId,
			@RequestParam int amount,
			@RequestParam String type,
			@RequestPart("receipt") Part file, 
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
		exp.save(); //Save to get id
		if (file.getSize() > 0) {
			storageService.store(file, receiptPrefix + exp.getExpenseId());
			if (exp.getReceipt() != null && !exp.getReceipt().isEmpty()) {
				storageService.delete(exp.getReceipt());
			}
			exp.setReceipt(storageService.getStoredPublicPath(file, receiptPrefix + exp.getExpenseId()));
		}
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
			model.addAttribute("receipt", exp.getReceipt());
			model.addAttribute("expense", exp);
		}
		return "show_receipts";
	}
}
