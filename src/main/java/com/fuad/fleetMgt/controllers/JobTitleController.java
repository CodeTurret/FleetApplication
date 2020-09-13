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
import com.fuad.fleetMgt.models.JobTitle;
//import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.JobTitleService;

@Controller
public class JobTitleController {

//	@GetMapping("/job")
//	public String job() {
//		// return the name of HTML file without extension
//		return "jobTitle";
//		
//	}
	@Autowired
	private JobTitleService jobTitleService;
	
	// Mapping path and return URL path dont need to be same
	@GetMapping("/jobtitles")
	public String getJobTitles(Model model) {
			
		// Store the list of jobTitles from Service.
		// for JobTitle list
		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles", jobTitleList);
		
		
		
		// return the name of HTML file without extension
		
		 return "jobTitle";
		
	}
	
	
	
	@PostMapping("/jobTitles/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitles";
	}
	
	@RequestMapping("jobTitles/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id){
		return jobTitleService.findById(id);
	}
	
	
	// update new State
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/jobTitles/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitles";
	}
	
	
	// Delete a jobTitle
	@RequestMapping(value="/jobTitles/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		jobTitleService.delete(id);
		return "redirect:/jobtitles";
	}

}
