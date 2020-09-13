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

import com.fuad.fleetMgt.models.Contact;
import com.fuad.fleetMgt.models.Country;
import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.ContactService;
import com.fuad.fleetMgt.services.CountryService;
import com.fuad.fleetMgt.services.StateService;

@Controller
public class ContactController {
	
//	@GetMapping("/contact")
//	public String getContact() {
//		// return the name of HTML file without extension
//		return "contact";
//		
//	}
	
	// Autowiring the contactService in controller
	@Autowired
	private ContactService contactService;
	
	// Autowire country, because we want to show the country list
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/contact")
	public String getContact(Model model) {
			
		// Store the list of contacts from Service.
		// getContacts is the method of contactService class
		List<Contact> contactList = contactService.getContacts(); 
		
		model.addAttribute("contacts", contactList);
		
		// We want to display the countries, so we bring country list
		List<Country> countryList = countryService.getCountries(); 
		
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.getStates(); 
		
		model.addAttribute("states", stateList);
		
		// return the name of HTML file without extension
		
		 return "contact2";
		
	}
	
		
	@PostMapping("/contacts/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	@RequestMapping("contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(int id){
		return contactService.findById(id);
	}
	
	
	// update new Contact
	// here we just call 'save' from ContactService. We dont need to write it everytime.
	@RequestMapping(value="/contacts/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Contact contact) {
		
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	
	// Delete a contact
	@RequestMapping(value="/contacts/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		contactService.delete(id);
		return "redirect:/contact";
	}

}
