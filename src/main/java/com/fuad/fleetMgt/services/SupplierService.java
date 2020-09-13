package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Supplier;
import com.fuad.fleetMgt.repositories.SupplierRepository;

@Service
public class SupplierService {
	

	// we need to autowire the Table from MySql
	@Autowired
	private SupplierRepository supplierRepository;
	
	// Return list of suppliers
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
	
	// Save a new Supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	// delete a supplier
	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<Supplier> findById(int id){
		return supplierRepository.findById(id);
	}

}
