
package edu.ualbany.icis518.team6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Employee;
import edu.ualbany.icis518.team6.Expense;
import edu.ualbany.icis518.team6.Projects;
import edu.ualbany.icis518.team6.Trips;

@Controller
public class HrController {
	
	@Autowired
	private HttpSession session;
	
	/*
	 * This method returns list of expenses with Submitted status
	 * along with history expenses.
	 */
	@RequestMapping("/hr")
	public String hrHomePage(@RequestParam String project_name, @RequestParam String employee_name, @RequestParam String trip_name, Model model) {
		
		if(session.getAttribute("employee")==null){
			return "redirect:/";
		}
		
		System.out.println(session.getAttribute("employee"));
		Expense exp = new Expense();
		List<Expense> submittedExpList = exp.getbyStatus("Submitted");
		List<Expense> historyExpList = exp.getbyStatus("Approved");
		historyExpList.addAll(exp.getbyStatus("Declined"));
		
		Projects project = new Projects();
		List<Projects> projectList = project.getAllProjects();
		Employee emp = new Employee();
		List<Employee> employeeList = emp.getAllEmployee();
		Trips trip = new Trips();
		List<Trips> tripList = trip.getAllTrips();
		
		model.addAttribute("expList", submittedExpList);
		model.addAttribute("historyExpList", historyExpList);
		model.addAttribute("projectList", projectList);
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("tripList", tripList);
	
		return "hr";
	}
	
	/*
	 * This method returns expense details associated with specific claim id
	 */
	@RequestMapping("/hr/claim")
	public String showClaim(@RequestParam(value="id", required=true) int id, Model model) {
		Expense exp = new Expense().getbyExpenseId(id);
		model.addAttribute("expense", exp);
		return "show_claim";
	}
	
	/*
	 * This method calls model class to submit claim action in database.
	 */
	@RequestMapping("/hr/claim/approve")
	public String processClaim(@RequestParam(value="id", required=true) int id, 
			@RequestParam String claimAction, @RequestParam String commentcontent, Model model){
		Expense exp = new Expense().getbyExpenseId(id);	
		Projects project = exp.getTrip().getProj();
		switch(claimAction){
			case "Approve":
				exp.setStatus("Approved");
				int amt = exp.getTrip().getProj().getBudget() - exp.getAmount();
				System.out.println(amt);
				project.setBudget(amt);
				exp.save();
				project.save();
				break;
			case "Decline":
				exp.setStatus("Declined");
				exp.save();
				break;
		}
		if(!commentcontent.isEmpty()){
			exp.setHr_comment(commentcontent);
			exp.save();
		}
		return "redirect:/hr";
	}
}

