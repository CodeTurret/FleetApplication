package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.VehicleStatus;
import com.fuad.fleetMgt.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	// we need to autowire the Table from MySql
		@Autowired
		private VehicleStatusRepository vehicleStatusRepository;
				
		// Return list of vehicleStatuss
		public List<VehicleStatus> getVehicleStatuss(){
			return vehicleStatusRepository.findAll();
		}
				
		// Save a new VehicleStatus
		public void save(VehicleStatus vehicleStatus) {
			vehicleStatusRepository.save(vehicleStatus);
		}
				
		// delete a vehicleStatus
		public void delete(Integer id) {
			vehicleStatusRepository.deleteById(id);
		}
				
		// get by ID
		public Optional<VehicleStatus> findById(int id){
			return vehicleStatusRepository.findById(id);
		}

}
