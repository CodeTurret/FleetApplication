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
import com.fuad.fleetMgt.models.EmployeeType;
//import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

//	@GetMapping("/employeetype")
//	public String employeetype() {
//		// return the name of HTML file without extension
//		return "employeeType";
//		
//	}
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeetypes")
	public String getEmployeeType(Model model) {
			
		// Store the list of employeeTypes from Service.
		// for EmployeeType list
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes", employeeTypeList);
		
		
		
		// return the name of HTML file without extension
		
		 return "employeeType";
		
	}
	
	
	// Mapping path and return URL path dont need to be same
	@PostMapping("/employeeTypes/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeetypes";
	}
	
	@RequestMapping("employeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id){
		return employeeTypeService.findById(id);
	}
	
	
	// update new State
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/employeeTypes/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		
		employeeTypeService.save(employeeType);
		return "redirect:/employeetypes";
	}
	
	
	// Delete a employeeType
	// 
	@RequestMapping(value="/employeeTypes/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		employeeTypeService.delete(id);
		// this is just the URL
		return "redirect:/employeetypes";
	}

}
