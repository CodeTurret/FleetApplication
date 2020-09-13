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

import com.fuad.fleetMgt.models.Location;
import com.fuad.fleetMgt.models.Vehicle;
import com.fuad.fleetMgt.models.VehicleMovement;
import com.fuad.fleetMgt.services.LocationService;
import com.fuad.fleetMgt.services.VehicleMovementService;
import com.fuad.fleetMgt.services.VehicleService;

@Controller
public class VehicleMovementController {

//	@GetMapping("/vehiclemovement")
//	public String vehicleMovement() {
//		// return the name of HTML file without extension
//		return "vehicleMovement";
//		
//	}
	// Autowiring the vehicleMovementService in controller
	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired private VehicleService vehicleService;
	@Autowired private LocationService locationService;
	
	@GetMapping("/vehiclemovement")
	public String getVehicleMovement(Model model) {
			
		// Store the list of vehicleMovements from Service.
		// getVehicleMovements is the method of vehicleMovementService class
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements(); 
		
		model.addAttribute("vehicleMovements", vehicleMovementList);
		
		// We want to display the countries, so we bring vehicle list
		List<Vehicle> vehicleList = vehicleService.getVehicles(); 
		
		model.addAttribute("vehicles", vehicleList);
		
		List<Location> locationList = locationService.getLocations(); 
		
		model.addAttribute("locations", locationList);
		
		// return the name of HTML file without extension
		
		 return "vehicleMovement";
		
	}
	
	
	
	@PostMapping("/vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovement";
	}
	
	@RequestMapping("vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id){
		return vehicleMovementService.findById(id);
	}
	
	
	// update new VehicleMovement
	// here we just call 'save' from VehicleMovementService. We dont need to write it everytime.
	@RequestMapping(value="/vehicleMovements/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovement";
	}
	
	
	// Delete a vehicleMovement
	@RequestMapping(value="/vehicleMovements/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleMovementService.delete(id);
		return "redirect:/vehiclemovement";
	}
	
	
}
