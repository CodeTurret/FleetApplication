package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.State;
import com.fuad.fleetMgt.repositories.StateRepository;

@Service
public class StateService {

	// we need to autowire the Table from MySql
	@Autowired
	private StateRepository stateRepository;
	
	// Return list of states
	public List<State> getStates(){
		return stateRepository.findAll();
	}
	
	// Save a new State
	public void save(State state) {
		stateRepository.save(state);
	}
	
	// delete a state
	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<State> findById(int id){
		return stateRepository.findById(id);
	}

}
