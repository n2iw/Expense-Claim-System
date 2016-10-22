package edu.ualbany.icis518.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Here {
	@RequestMapping("/here")
	@ResponseBody
	public String here() {
		return "Here we go!";
	}
}