package com.fuad.fleetMgt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	@GetMapping("/index")
	public String goHome() {
		return "index";
	}
	
	// Login
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// Logout
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
}
