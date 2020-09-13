package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.VehicleHire;
import com.fuad.fleetMgt.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

		// we need to autowire the Table from MySql
		@Autowired
		private VehicleHireRepository vehicleHireRepository;
		
		// Return list of vehicleHires
		public List<VehicleHire> getVehicleHires(){
			return vehicleHireRepository.findAll();
		}
		
		// Save a new VehicleHire
		public void save(VehicleHire vehicleHire) {
			vehicleHireRepository.save(vehicleHire);
		}
		
		// delete a vehicleHire
		public void delete(Integer id) {
			vehicleHireRepository.deleteById(id);
		}
		
		// get by ID
		public Optional<VehicleHire> findById(int id){
			return vehicleHireRepository.findById(id);
		}


}
