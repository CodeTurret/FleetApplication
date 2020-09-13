package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.VehicleMovement;
import com.fuad.fleetMgt.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {


	// we need to autowire the Table from MySql
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	// Return list of vehicleMovements
	public List<VehicleMovement> getVehicleMovements(){
		return vehicleMovementRepository.findAll();
	}
	
	// Save a new VehicleMovement
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	// delete a vehicleMovement
	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<VehicleMovement> findById(int id){
		return vehicleMovementRepository.findById(id);
	}

}
