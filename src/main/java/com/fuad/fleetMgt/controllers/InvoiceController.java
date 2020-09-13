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

import com.fuad.fleetMgt.models.Client;
import com.fuad.fleetMgt.models.Invoice;
import com.fuad.fleetMgt.models.InvoiceStatus;

import com.fuad.fleetMgt.services.ClientService;

import com.fuad.fleetMgt.services.InvoiceService;
import com.fuad.fleetMgt.services.InvoiceStatusService;


@Controller
public class InvoiceController {

//	@GetMapping("/invoice")
//	public String getInvoice() {
//		// return the name of HTML file without extension
//		return "invoice";
//		
//	}
	
	// Autowiring the invoiceService in controller
		
		
		@Autowired
		private ClientService clientService;
		@Autowired
		private InvoiceStatusService InvoiceStatusService;
		
		@Autowired
		private InvoiceService invoiceService;
		
		@GetMapping("/invoice")
		public String getInvoice(Model model) {
				
			// Store the list of states from Service.
			// getInvoices is the method of stateService class
			
			
			// We want to display the clients, so we bring client list
			List<Client> clientList = clientService.getClients(); 
			
			model.addAttribute("clients", clientList);
			
			List<Invoice> invoiceList = invoiceService.getInvoices(); 
			
			model.addAttribute("invoices", invoiceList);
			
			List<InvoiceStatus> invoiceStatusList = InvoiceStatusService.getInvoiceStatuses();
			model.addAttribute("invoiceStatuses", invoiceStatusList);
			// return the name of HTML file without extension
			
			 return "invoice";
			
		}
		
		
		
		@PostMapping("/invoices/addNew")
		public String addNew(Invoice invoice) {
			invoiceService.save(invoice);
			return "redirect:/invoice";
		}
		
		@RequestMapping("invoices/findById")
		@ResponseBody
		public Optional<Invoice> findById(int id){
			return invoiceService.findById(id);
		}
		
		
		// update new Invoice
		// here we just call 'save' from InvoiceService. We dont need to write it everytime.
		@RequestMapping(value="/invoices/update" ,method = {RequestMethod.PUT,RequestMethod.GET})
		public String update(Invoice invoice) {
			
			invoiceService.save(invoice);
			return "redirect:/invoice";
		}
		
		
		// Delete a state
		@RequestMapping(value="/invoices/delete" ,method = {RequestMethod.DELETE,RequestMethod.GET})
		public String delete(Integer id) {
			// delete method from Service class
			invoiceService.delete(id);
			return "redirect:/invoice";
		}
		
		
}
