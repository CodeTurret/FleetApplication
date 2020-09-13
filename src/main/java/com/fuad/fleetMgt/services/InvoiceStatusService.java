package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.InvoiceStatus;
import com.fuad.fleetMgt.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	// we need to autowire the Table from MySql
		@Autowired
		private InvoiceStatusRepository invoiceStatusRepository;
				
		// Return list of invoiceStatuss
		public List<InvoiceStatus> getInvoiceStatuses(){
			return invoiceStatusRepository.findAll();
		}
				
		// Save a new InvoiceStatus
		public void save(InvoiceStatus invoiceStatus) {
			invoiceStatusRepository.save(invoiceStatus);
		}
				
		// delete a invoiceStatus
		public void delete(Integer id) {
			invoiceStatusRepository.deleteById(id);
		}
				
		// get by ID
		public Optional<InvoiceStatus> findById(int id){
			return invoiceStatusRepository.findById(id);
		}

}
