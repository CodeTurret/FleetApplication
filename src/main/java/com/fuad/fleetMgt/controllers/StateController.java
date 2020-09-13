package com.fuad.fleetMgt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuad.fleetMgt.models.Country;
import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.CountryService;
import com.fuad.fleetMgt.services.StateService;

@Controller
public class StateController {
	
	
//	@GetMapping("/states")
//	public String getState() {
//		// return the name of HTML file without extension
//		return "state";
//		
//	}
	
	
	// Autowiring the stateService in controller
	@Autowired
	private StateService stateService;
	
	// Autowire country, because we want to show the country list
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/states")
	public String getState(Model model) {
			
		// Store the list of states from Service.
		// getStates is the method of stateService class
		List<State> stateList = stateService.getStates(); 
		
		model.addAttribute("states", stateList);
		
		// We want to display the countries, so we bring country list
		List<Country> countryList = countryService.getCountries(); 
		
		model.addAttribute("countries", countryList);
		
		
		
		// return the name of HTML file without extension
		
		 return "state";
		
	}
	
	
	
	@PostMapping("/states/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	
	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id){
		return stateService.findById(id);
	}
	
	
	// update new State
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/states/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(State state) {
		
		stateService.save(state);
		return "redirect:/states";
	}
	
	
	// Delete a state
	@RequestMapping(value="/states/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		stateService.delete(id);
		return "redirect:/states";
	}
	
}
