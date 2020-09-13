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
import com.fuad.fleetMgt.models.Location;
import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.CountryService;
import com.fuad.fleetMgt.services.LocationService;
import com.fuad.fleetMgt.services.StateService;

@Controller
public class LocationController {
	
	/*
	@GetMapping("/location")
	public String location() {
		// return the name of HTML file without extension
		return "location";
		
	}
	*/

	
	// Autowiring the stateService in controller
	@Autowired
	private StateService stateService;
	
	// Autowire country, because we want to show the country list
	@Autowired
	private CountryService countryService;
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locations")
	public String getState(Model model) {
			
		// Store the list of locations from Service.
		// getStates is the method of locationService class
		List<State> stateList = stateService.getStates(); 
		
		model.addAttribute("states", stateList);
		
		// We want to display the countries, so we bring country list
		List<Country> countryList = countryService.getCountries(); 
		
		model.addAttribute("countries", countryList);
		
		// for Location list
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
		
		
		
		// return the name of HTML file without extension
		
		 return "location";
		
	}
	
	
	
	@PostMapping("/locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id){
		return locationService.findById(id);
	}
	
	
	// update new State
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/locations/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Location location) {
		
		locationService.save(location);
		return "redirect:/locations";
	}
	
	
	// Delete a location
	@RequestMapping(value="/locations/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		locationService.delete(id);
		return "redirect:/locations";
	}

}
