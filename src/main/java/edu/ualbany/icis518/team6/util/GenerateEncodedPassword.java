package edu.ualbany.icis518.team6.util;

import java.util.Base64;

import org.springframework.context.annotation.Bean;


public class GenerateEncodedPassword {
	
	/*
	 * This method gives encoded password.
	 * We are using Spring BCryptPasswordEncoder to encrypt password.
	 */
	@Bean
	public String getEncodedPassword(String password) {
		String base64encodedString = Base64.getEncoder().encodeToString(password.getBytes());
		return base64encodedString;
	  }
}
