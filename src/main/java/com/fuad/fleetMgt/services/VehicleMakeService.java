package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.VehicleMake;
import com.fuad.fleetMgt.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	// we need to autowire the Table from MySql
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
			
	// Return list of vehicleMakes
	public List<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
	}
			
	// Save a new VehicleMake
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
			
	// delete a vehicleMake
	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}
			
	// get by ID
	public Optional<VehicleMake> findById(int id){
		return vehicleMakeRepository.findById(id);
	}

}
