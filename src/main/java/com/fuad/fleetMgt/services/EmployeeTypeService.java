package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.EmployeeType;
import com.fuad.fleetMgt.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	// we need to autowire the Table from MySql
		@Autowired
		private EmployeeTypeRepository employeeTypeRepository;
				
		// Return list of employeeTypes
		public List<EmployeeType> getEmployeeTypes(){
			return employeeTypeRepository.findAll();
		}
				
		// Save a new EmployeeType
		public void save(EmployeeType employeeType) {
			employeeTypeRepository.save(employeeType);
		}
				
		// delete a employeeType
		public void delete(Integer id) {
			employeeTypeRepository.deleteById(id);
		}
				
		// get by ID
		public Optional<EmployeeType> findById(int id){
			return employeeTypeRepository.findById(id);
		}

}
