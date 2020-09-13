package com.fuad.fleetMgt.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fuad.fleetMgt.services.EmployeeService;

@Controller
public class ProfileController {

	@Autowired private EmployeeService employeeService; 
	
	@RequestMapping(value="/profile")
	public String profile(Model model, Principal principal) {
		
		// principal is the logged in user
		
		String un = principal.getName();
		
		model.addAttribute("employee",employeeService.findByUsername(un));
		
		return "profile";
	}
}
