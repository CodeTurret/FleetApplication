package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.VehicleModel;
import com.fuad.fleetMgt.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	// we need to autowire the Table from MySql
		@Autowired
		private VehicleModelRepository vehicleModelRepository;
				
		// Return list of vehicleModels
		public List<VehicleModel> getVehicleModels(){
			return vehicleModelRepository.findAll();
		}
				
		// Save a new VehicleModel
		public void save(VehicleModel vehicleModel) {
			vehicleModelRepository.save(vehicleModel);
		}
				
		// delete a vehicleModel
		public void delete(Integer id) {
			vehicleModelRepository.deleteById(id);
		}
				
		// get by ID
		public Optional<VehicleModel> findById(int id){
			return vehicleModelRepository.findById(id);
		}

}
