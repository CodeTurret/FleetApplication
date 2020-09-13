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
import com.fuad.fleetMgt.models.InvoiceStatus;
//import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

//	@GetMapping("/invoicestatus")
//	public String getInvoiceStatus() {
//		// return the name of HTML file without extension
//		return "invoiceStatus";
//		
//	}
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoiceStatuses")
	public String getState(Model model) {
			
		// Store the list of invoiceStatuss from Service.
		// for InvoiceStatus list
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
		model.addAttribute("invoiceStatuses", invoiceStatusList);
		
		
		
		// return the name of HTML file without extension
		
		 return "invoiceStatus";
		
	}
	
	
	
	@PostMapping("/invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping("invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id){
		return invoiceStatusService.findById(id);
	}
	
	
	// update new invoice
	// here we just call 'save' from StateService. We dont need to write it everytime.
	@RequestMapping(value="/invoiceStatuses/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	
	// Delete a invoiceStatus
	@RequestMapping(value="/invoiceStatuses/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		// delete method from Service class
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}

}
