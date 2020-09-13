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

import com.fuad.fleetMgt.models.Vehicle;
import com.fuad.fleetMgt.services.EmployeeService;
import com.fuad.fleetMgt.services.LocationService;
import com.fuad.fleetMgt.services.VehicleMakeService;
import com.fuad.fleetMgt.services.VehicleModelService;
import com.fuad.fleetMgt.services.VehicleService;
import com.fuad.fleetMgt.services.VehicleStatusService;
import com.fuad.fleetMgt.services.VehicleTypeService;


@Controller
public class VehicleController {


	
	/*
	 * Location
	 * Employee
	 * Vehicle Make
	 * Vehicle Status
	 * Vehicle Type
	 * Vehicle Model
	 * Vehicles
	 */
	@Autowired private VehicleService vehicleService;
	@Autowired private LocationService locationService;
	@Autowired private EmployeeService employeeService;
	@Autowired private VehicleMakeService vehicleMakeService;
	@Autowired private VehicleStatusService vehicleStatusService;
	@Autowired private VehicleTypeService vehicleTypeService;
	@Autowired private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehicle")
	public String getVehicle(Model model) {
			
		// Store the list of vehicles from Service.
		// getVehicles is the method of vehicleService class
		List<Vehicle> vehicleList = vehicleService.getVehicles(); 
		
		model.addAttribute("vehicles", vehicleList);
		
		// another way to save the list
		model.addAttribute("locations",locationService.getLocations());
		model.addAttribute("employees",employeeService.getEmployees());
		model.addAttribute("vehicleMakes",vehicleMakeService.getVehicleMakes());
		model.addAttribute("vehicleStatuss",vehicleStatusService.getVehicleStatuss());
		model.addAttribute("vehicleTypes",vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels",vehicleModelService.getVehicleModels());
		
		// return the name of HTML file without extension
		
		 return "vehicle";
		
	}
	
	
	
	@PostMapping("/vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}
	
	@RequestMapping("vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id){
		return vehicleService.findById(id);
	}
	
	
	// update new Vehicle
	// here we just call 'save' from VehicleService. We dont need to write it everytime.
	@RequestMapping(value="/vehicles/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Vehicle vehicle) {
		
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}
	
	
	// Delete a vehicle
	@RequestMapping(value="/vehicles/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleService.delete(id);
		return "redirect:/vehicle";
	}
	
}
