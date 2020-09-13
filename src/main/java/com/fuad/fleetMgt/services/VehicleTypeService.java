package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.VehicleType;
import com.fuad.fleetMgt.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	// we need to autowire the Table from MySql
		@Autowired
		private VehicleTypeRepository vehicleTypeRepository;
				
		// Return list of vehicleTypes
		public List<VehicleType> getVehicleTypes(){
			return vehicleTypeRepository.findAll();
		}
				
		// Save a new VehicleType
		public void save(VehicleType vehicleType) {
			vehicleTypeRepository.save(vehicleType);
		}
				
		// delete a vehicleType
		public void delete(Integer id) {
			vehicleTypeRepository.deleteById(id);
		}
				
		// get by ID
		public Optional<VehicleType> findById(int id){
			return vehicleTypeRepository.findById(id);
		}

}
