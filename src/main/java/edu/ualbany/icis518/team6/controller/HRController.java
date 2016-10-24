package edu.ualbany.icis518.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HRController {
	
	@RequestMapping("/hr")
	public String hr() {
		return "hr";
	}

	@RequestMapping("/hr/claim")
	public String show_claim() {
		return "show_claim";
	}
}