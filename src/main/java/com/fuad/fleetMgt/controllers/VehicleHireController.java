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

import com.fuad.fleetMgt.models.Client;
import com.fuad.fleetMgt.models.Location;
import com.fuad.fleetMgt.models.Vehicle;
import com.fuad.fleetMgt.models.VehicleHire;
import com.fuad.fleetMgt.services.ClientService;
import com.fuad.fleetMgt.services.LocationService;
import com.fuad.fleetMgt.services.VehicleHireService;
import com.fuad.fleetMgt.services.VehicleService;

@Controller
public class VehicleHireController {

//	@GetMapping("/vehiclehire")
//	public String vehicleHire() {
//		// return the name of HTML file without extension
//		return "vehicleHire";
//		
//	}
	@Autowired private VehicleHireService vehicleHireService;
	@Autowired private VehicleService vehicleService;
	@Autowired private LocationService locationService;
	@Autowired private ClientService clientService;
	
	@GetMapping("/vehiclehire")
	public String getState(Model model) {
			
		// Store the list of vehicleHires from Service.		
		// for VehicleHire list
		List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
		model.addAttribute("vehicleHires", vehicleHireList);
		
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);
		
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
		
		List<Client> clientList = clientService.getClients();
		model.addAttribute("clients", clientList);
		
		// return the name of HTML file without extension
		
		 return "vehicleHire";
		
	}
	
	
	
	@PostMapping("/vehicleHires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}
	
	@RequestMapping("vehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id){
		return vehicleHireService.findById(id);
	}
	
	
	// update new vehicle Hire
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/vehicleHires/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}
	
	
	// Delete a vehicleHire
	@RequestMapping(value="/vehicleHires/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleHireService.delete(id);
		return "redirect:/vehiclehire";
	}
	
}
