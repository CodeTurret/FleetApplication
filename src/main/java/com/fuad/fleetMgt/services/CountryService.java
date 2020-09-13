package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Country;
import com.fuad.fleetMgt.repositories.CountryRepository;

@Service
public class CountryService {

	// we need to autowire the Table from MySql
	@Autowired
	private CountryRepository countryRepository;
	
	// Return list of countries
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}
	
	// Save a new Country
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	// delete a country
	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<Country> findById(int id){
		return countryRepository.findById(id);
	}
}
