package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Invoice;
import com.fuad.fleetMgt.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	// we need to autowire the Table from MySql
		@Autowired
		private InvoiceRepository invoiceRepository;
		
		// Return list of invoices
		public List<Invoice> getInvoices(){
			return invoiceRepository.findAll();
		}
		
		// Save a new Invoice
		public void save(Invoice invoice) {
			invoiceRepository.save(invoice);
		}
		
		// delete a invoice
		public void delete(Integer id) {
			invoiceRepository.deleteById(id);
		}
		
		// get by ID
		public Optional<Invoice> findById(int id){
			return invoiceRepository.findById(id);
		}
		
		
}
