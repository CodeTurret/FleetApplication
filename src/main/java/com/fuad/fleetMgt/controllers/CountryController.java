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
import com.fuad.fleetMgt.services.CountryService;

@Controller
public class CountryController {

	// Autowiring the countryService in controller
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countries")
	public String getCountries(Model model) {
		
		// Store the list of countries from Service.
		// getCountries is the method of countryService class
		List<Country> countryList = countryService.getCountries(); 
		
		model.addAttribute("countries", countryList);
		
		// return the name of HTML file without extension
		return "country";
		
	}
	
	@PostMapping("/countries/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping("countries/findById")
	@ResponseBody
	public Optional<Country> findById(int id){
		return countryService.findById(id);
	}
	
	
	// update new Country
	// here we just call 'save' from CountryService. We dont need to write it everytime.
	@RequestMapping(value="/countries/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Country country) {
		
		countryService.save(country);
		return "redirect:/countries";
	}
	
	
	// Delete a country
	@RequestMapping(value="/countries/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		countryService.delete(id);
		return "redirect:/countries";
	}
	
}
