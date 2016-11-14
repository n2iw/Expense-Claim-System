package edu.ualbany.icis518.team6.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateEncodedPassword {
	
	/*
	 * This method gives encoded password.
	 * We are using Spring BCryptPasswordEncoder to encrypt password.
	 */
	public String getEncodedPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
		return hashedPassword;
	  }
}
