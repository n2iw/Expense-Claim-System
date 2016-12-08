
package edu.ualbany.icis518.team6.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Projects;
import edu.ualbany.icis518.team6.Trips;
import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.EmployeeTrips;

@Controller
public class HrController {
	
	@Autowired
	private HttpSession session;
	
	/*
	 * This method returns list of expenses with Submitted status
	 * along with history expenses.
	 */
	@RequestMapping("/hr")
	public String hrHomePage(Model model) {
		
		Employee emp = (Employee)session.getAttribute("employee");
		if(emp==null){
			return "redirect:/";
		}else if(!emp.getRole().equalsIgnoreCase("HR")){
			if(emp.getRole().equalsIgnoreCase("manager"))
				return "redirect:/manager";		
			else
				return "redirect:/" + "employee?id=" + emp.getEmployeeId();
		}
		
		Expense exp = new Expense();
		List<Expense> submittedExpList = exp.getbyStatus("In Progress");
		submittedExpList.addAll(exp.getbyStatus("Submitted"));
		List<Expense> historyExpList = exp.getbyStatus("Approved");
		historyExpList.addAll(exp.getbyStatus("Declined"));
		
		Projects project = new Projects();
		List<Projects> projectList = project.getAllProjects();
		EmployeeTrips empTrips = new EmployeeTrips();
		List<EmployeeTrips> empTripList = empTrips.getAllEmployeeTrips();
		Trips trip = new Trips();
		List<Trips> tripList = trip.getAllTrips();
		
		model.addAttribute("expList", submittedExpList);
		model.addAttribute("historyExpList", historyExpList);
		model.addAttribute("projectList", projectList);
		model.addAttribute("empTripList", empTripList);
		model.addAttribute("tripList", tripList);
		
		return "hr";
	}
	
	/*
	 * This method returns expense details associated with specific claim id
	 */
	@RequestMapping("/hr/claim")
	public String showClaim(@RequestParam(value="id", required=true) int id, Model model) {
		if(session.getAttribute("employee")==null){
			return "redirect:/";
		}
		
		Expense exp = new Expense().getbyExpenseId(id);
		model.addAttribute("expense", exp);
		return "show_claim";
	}
	
	/*
	 * This method calls model class to submit claim action in database.
	 */
	@RequestMapping("/hr/claim/approve")
	public String processClaim(@RequestParam(value="id", required=true) int id, 
			@RequestParam String claimAction, Model model){
		
		if(session.getAttribute("employee")==null){
			return "redirect:/";
		}
		
		Expense exp = new Expense().getbyExpenseId(id);	
		Projects project = exp.getTrip().getProj();
		switch(claimAction){
			case "Approve":
				exp.setStatus("Approved");
				int amount = exp.getTrip().getProj().getCurrentBudget() - exp.getAmount();
				project.setCurrentBudget(amount);
				exp.save();
				project.save();
				break;
			case "Decline":
				exp.setStatus("Declined");
				exp.save();
				break;
			case "Save":
				exp.setStatus("In Progress");
				exp.save();
				break;
		}
		return "redirect:/hr";
	}
}

