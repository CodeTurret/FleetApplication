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
import com.fuad.fleetMgt.models.VehicleMake;
//import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.VehicleMakeService;

@Controller
public class VehicleMakeController {

//	@GetMapping("/vehiclemake")
//	public String vehicleMake() {
//		// return the name of HTML file without extension
//		return "vehicleMake";
//		
//	}
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehicleMakes")
	public String getState(Model model) {
			
		
		
		// for VehicleMake list
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakeList);
		
		
		
		// return the name of HTML file without extension
		
		 return "vehicleMake";
		
	}
	
	
	
	@PostMapping("/vehicleMakes/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}
	
	@RequestMapping("vehicleMakes/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id){
		return vehicleMakeService.findById(id);
	}
	
	
	// update new vehicle maker
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/vehicleMakes/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}
	
	
	// Delete a vehicleMake
	@RequestMapping(value="/vehicleMakes/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleMakeService.delete(id);
		return "redirect:/vehicleMakes";
	}

}
