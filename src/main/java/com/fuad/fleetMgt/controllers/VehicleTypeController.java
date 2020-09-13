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

//import com.fuad.fleetMgt.models.Country;
import com.fuad.fleetMgt.models.VehicleType;
//import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

//	@GetMapping("/vehicletype")
//	public String getVehicleType() {
//		// return the name of HTML file without extension
//		return "vehicleType";
//		
//	}
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicleTypes")
	public String getState(Model model) {
			
		// Store the list of vehicleTypes from Service.
		
		// for VehicleType list
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypeList);
		
		
		
		// return the name of HTML file without extension
		
		 return "vehicleType";
		
	}
	
	
	
	@PostMapping("/vehicleTypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping("vehicleTypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id){
		return vehicleTypeService.findById(id);
	}
	
	
	// update new State
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/vehicleTypes/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	
	// Delete a vehicleType
	@RequestMapping(value="/vehicleTypes/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	}

}
