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
import com.fuad.fleetMgt.models.Vehicle;
import com.fuad.fleetMgt.models.VehicleMaintenance;


import com.fuad.fleetMgt.services.VehicleMaintenanceService;
import com.fuad.fleetMgt.services.VehicleService;

import com.fuad.fleetMgt.services.SupplierService;

@Controller
public class VehicleMaintenanceController {

//	@GetMapping("/vehiclemaintenance")
//	public String vehicleMaintenance() {
//		// return the name of HTML file without extension
//		return "vehicleMaintenance";
//		
//	}
	
	// Autowiring the vehicleMaintenanceService in controller
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired private VehicleService vehicleService;
	@Autowired private SupplierService supplierService;
	
	@GetMapping("/vehiclemaintenance")
	public String getVehicleMaintenance(Model model) {
			
		// Store the list of vehicleMaintenances from Service.
		// getVehicleMaintenances is the method of vehicleMaintenanceService class
		List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances(); 
		
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);
		
		// We want to display the vehicles, so we bring vehicle list
		List<Vehicle> vehicleList = vehicleService.getVehicles(); 
		
		//model.addAttribute("countries", vehicleList);
		model.addAttribute("vehicles", vehicleList);
		
		List<Supplier> supplierList = supplierService.getSuppliers(); 
		
		model.addAttribute("suppliers", supplierList);
		
		// return the name of HTML file without extension
		
		 return "vehicleMaintenance";
		
	}
	
	
	
	@PostMapping("/vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenance";
	}
	
	@RequestMapping("vehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id){
		return vehicleMaintenanceService.findById(id);
	}
	
	
	// update new VehicleMaintenance
	// here we just call 'save' from VehicleMaintenanceService. We dont need to write it everytime.
	@RequestMapping(value="/vehicleMaintenances/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenance";
	}
	
	
	// Delete a vehicleMaintenance
	@RequestMapping(value="/vehicleMaintenances/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehiclemaintenance";
	}
	
	
}
