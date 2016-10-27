package edu.ualbany.icis518.team6.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ualbany.icis518.team6.Expense;

@Controller
public class HrController {
	
	@RequestMapping("/hr")
	public String hrHomePage(Model model) {
		Expense exp = new Expense();
		List<Expense> submittedExpList = exp.getbyStatus("Submitted");
		List<Expense> historyExpList = exp.getbyStatus("Approved");
		historyExpList.addAll(exp.getbyStatus("Declined"));
		
		model.addAttribute("expList", submittedExpList);
		model.addAttribute("historyExpList", historyExpList);
		return "hr";
	}

	@RequestMapping("/hr/claim")
	public String showClaim(@RequestParam(value="id", required=true) int id, Model model) {
		Expense exp = new Expense().getbyExpenseId(id);
		model.addAttribute("expense", exp);
		return "show_claim";
	}
	
	@RequestMapping("/hr/claim/approve")
	public String processClaim(@RequestParam(value="id", required=true) int id, 
			@RequestParam String claimAction, Model model){
		Expense exp = new Expense().getbyExpenseId(id);	
		switch(claimAction){
			case "Approve":
				exp.setStatus("Approved");
				exp.save();
				break;
			case "Decline":
				exp.setStatus("Declined");
				exp.save();
				break;
		}
		return "redirect:/hr";
	}
}

