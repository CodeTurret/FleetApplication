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

import com.fuad.fleetMgt.models.Supplier;
import com.fuad.fleetMgt.models.Country;
import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.SupplierService;
import com.fuad.fleetMgt.services.CountryService;
import com.fuad.fleetMgt.services.StateService;

@Controller
public class SupplierController {

//	@GetMapping("/supplier")
//	public String getSupplier() {
//		// return the name of HTML file without extension
//		return "supplier";
//		
//	}
	// Autowiring the supplierService in controller
	@Autowired
	private SupplierService supplierService;
	
	// Autowire country, because we want to show the country list
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/supplier")
	public String getSupplier(Model model) {
			
		// Store the list of suppliers from Service.
		// getSuppliers is the method of supplierService class
		List<Supplier> supplierList = supplierService.getSuppliers(); 
		
		model.addAttribute("suppliers", supplierList);
		
		// We want to display the countries, so we bring country list
		List<Country> countryList = countryService.getCountries(); 
		
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.getStates(); 
		
		model.addAttribute("states", stateList);
		
		// return the name of HTML file without extension
		
		 return "supplier";
		
	}
	
	
	
	@PostMapping("/suppliers/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	
	@RequestMapping("suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id){
		return supplierService.findById(id);
	}
	
	
	// update new Supplier
	// here we just call 'save' from SupplierService. We dont need to write it everytime.
	@RequestMapping(value="/suppliers/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Supplier supplier) {
		
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	
	
	// Delete a supplier
	@RequestMapping(value="/suppliers/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		supplierService.delete(id);
		return "redirect:/supplier";
	}

}
