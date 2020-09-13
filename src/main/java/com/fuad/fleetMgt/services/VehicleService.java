package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Vehicle;
import com.fuad.fleetMgt.repositories.VehicleRepository;

@Service
public class VehicleService {
	
//	@Autowired private VehicleRepository vehicleRepository;
//	
//	// Return list of vehicles
//	public List<Vehicle> getVehicles(){
//		return vehicleRepository.findAll();
//	}
	// we need to autowire the Table from MySql
	@Autowired
	private VehicleRepository vehicleRepository;
	
	// Return list of vehicles
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}
	
	// Save a new Vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	// delete a vehicle
	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<Vehicle> findById(int id){
		return vehicleRepository.findById(id);
	}


	
}
