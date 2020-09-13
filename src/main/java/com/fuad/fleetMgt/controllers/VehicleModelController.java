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
import com.fuad.fleetMgt.models.VehicleModel;
//import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.VehicleModelService;

@Controller
public class VehicleModelController {

//	@GetMapping("/vehiclemodel")
//	public String getVehicleModel() {
//		// return the name of HTML file without extension
//		return "vehicleModel";
//		
//	}
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehicleModels")
	public String getModels(Model model) {
			
		// Store the list of vehicleModels from Service.		
		// for VehicleModel list
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModelList);
		
		
		
		// return the name of HTML file without extension
		
		 return "vehicleModel";
		
	}
	
	
	
	@PostMapping("/vehicleModels/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}
	
	@RequestMapping("vehicleModels/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id){
		return vehicleModelService.findById(id);
	}
	
	
	// update new vehicle Model
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/vehicleModels/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}
	
	
	// Delete a vehicleModel
	@RequestMapping(value="/vehicleModels/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		vehicleModelService.delete(id);
		return "redirect:/vehicleModels";
	}

}
