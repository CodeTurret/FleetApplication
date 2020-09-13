package com.fuad.fleetMgt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fuad.fleetMgt.models.User;
import com.fuad.fleetMgt.services.UserService;

@Controller
public class UserController {

	@Autowired private UserService userService;
	
	
	@GetMapping("/user")
	public String getUser() {
		// return the name of HTML file without extension
		return "user";
		
	}
	
	//Modified method to Add a new user User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);	
		RedirectView  redirectView= new RedirectView("/login",true);
	        redir.addFlashAttribute("message", "You successfully registered! You can now login");
	    return redirectView;				
	}	
}
