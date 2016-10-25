package edu.ualbany.icis518.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HRController {
	
	@RequestMapping("/hr")
	public String hrHomePage() {
		return "hr";
	}

	@RequestMapping("/hr/claim")
	public String showClaim() {
		return "show_claim";
	}
}