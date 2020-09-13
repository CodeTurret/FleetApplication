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
import com.fuad.fleetMgt.models.VehicleStatus;
//import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

//	@GetMapping("/vehiclestatus")
//	public String getVehicleStatus() {
//		// return the name of HTML file without extension
//		return "vehicleStatus";
//		
//	}
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@GetMapping("/vehicleStatus")
	public String getState(Model model) {
			
		// Store the list of vehicleStatuss from Service.
		
		// for VehicleStatus list
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuss();
		model.addAttribute("vehicleStatuss", vehicleStatusList);
		
		
		
		// return the name of HTML file without extension
		
		 return "vehicleStatus";
		
	}
	
	
	
	@PostMapping("/vehicleStatuss/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}
	
	@RequestMapping("vehicleStatuss/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id){
		return vehicleStatusService.findById(id);
	}
	
	
	// update new State
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/vehicleStatuss/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}
	
	
	// Delete a vehicleStatus
	@RequestMapping(value="/vehicleStatuss/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatus";
	}

}
