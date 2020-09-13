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

import com.fuad.fleetMgt.models.Employee;
import com.fuad.fleetMgt.services.EmployeeService;
import com.fuad.fleetMgt.services.StateService;
import com.fuad.fleetMgt.services.CountryService;
import com.fuad.fleetMgt.services.EmployeeTypeService;
import com.fuad.fleetMgt.services.JobTitleService;

@Controller
public class EmployeeController {

//	@GetMapping("/employee")
//	public String employee() {
//		// return the name of HTML file without extension
//		return "employee";
//		
//	}
	
	@Autowired private EmployeeService employeeService;
	@Autowired private JobTitleService jobTitleService;
	@Autowired private EmployeeTypeService employeeTypeService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;
	
	
	@GetMapping("/employee")
	public String getEmployee(Model model) {
			
		// Store the list of employees from Service.
		// getEmployees is the method of employeeService class
		List<Employee> employeeList = employeeService.getEmployees(); 
		
		model.addAttribute("employees", employeeList);
		
		// another way to save the list
		model.addAttribute("jobTitles",jobTitleService.getJobTitles());
		model.addAttribute("employees",employeeService.getEmployees());
		model.addAttribute("employeeTypes",employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries",countryService.getCountries());
		model.addAttribute("states",stateService.getStates());
		
		// return the name of HTML file without extension
		
		 return "employee";
		
	}
	
	
	
	@PostMapping("/employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@RequestMapping("employees/findById")
	@ResponseBody
	public Optional<Employee> findById(int id){
		return employeeService.findById(id);
	}
	
	
	// update new Employee
	// here we just call 'save' from EmployeeService. We dont need to write it everytime.
	@RequestMapping(value="/employees/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Employee employee) {
		
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	
	// Delete a employee
	@RequestMapping(value="/employees/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		employeeService.delete(id);
		return "redirect:/employee";
	}

}
