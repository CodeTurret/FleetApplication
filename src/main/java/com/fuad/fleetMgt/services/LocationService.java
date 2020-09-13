package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Location;
import com.fuad.fleetMgt.repositories.LocationRepository;

@Service
public class LocationService {

	// we need to autowire the Table from MySql
		@Autowired
		private LocationRepository locationRepository;
		
		// Return list of locations
		public List<Location> getLocations(){
			return locationRepository.findAll();
		}
		
		// Save a new Location
		public void save(Location location) {
			locationRepository.save(location);
		}
		
		// delete a location
		public void delete(Integer id) {
			locationRepository.deleteById(id);
		}
		
		// get by ID
		public Optional<Location> findById(int id){
			return locationRepository.findById(id);
		}

}
