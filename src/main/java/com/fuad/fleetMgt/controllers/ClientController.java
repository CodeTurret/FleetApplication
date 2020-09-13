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
import com.fuad.fleetMgt.models.Client;
import com.fuad.fleetMgt.services.CountryService;
import com.fuad.fleetMgt.services.StateService;
import com.fuad.fleetMgt.services.ClientService;

@Controller
public class ClientController {
	
//	@GetMapping("/client")
//	public String clients() {
//		// return the name of HTML file without extension
//		return "client";
//		
//	}
	
		// Autowiring the clientService in controller
		@Autowired
		private ClientService clientService;
		
		// Autowire country, because we want to show the country list
		@Autowired
		private CountryService countryService;
		
		@Autowired
		private StateService stateService;
		
		@GetMapping("/client")
		public String getClient(Model model) {
				
			// Store the list of clients from Service.
			// getClients is the method of clientService class
			List<Client> clientList = clientService.getClients(); 
			
			model.addAttribute("clients", clientList);
			
			// We want to display the countries, so we bring country list
			List<Country> countryList = countryService.getCountries(); 
			
			model.addAttribute("countries", countryList);
			
			List<State> stateList = stateService.getStates(); 
			
			model.addAttribute("states", stateList);
			
			// return the name of HTML file without extension
			
			 return "client";
			
		}
		
		
		
		@PostMapping("/clients/addNew")
		public String addNew(Client client) {
			clientService.save(client);
			return "redirect:/client";
		}
		
		@RequestMapping("clients/findById")
		@ResponseBody
		public Optional<Client> findById(int id){
			return clientService.findById(id);
		}
		
		
		// update new Client
		// here we just call 'save' from ClientService. We dont need to write it everytime.
		@RequestMapping(value="/clients/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
		public String update(Client client) {
			
			clientService.save(client);
			return "redirect:/client";
		}
		
		
		// Delete a client
		@RequestMapping(value="/clients/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
		public String delete(Integer id) {
			// delete method from Service class
			clientService.delete(id);
			return "redirect:/client";
		}
		
}
