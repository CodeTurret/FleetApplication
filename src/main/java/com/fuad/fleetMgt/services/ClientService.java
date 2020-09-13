package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Client;
import com.fuad.fleetMgt.repositories.ClientRepository;

@Service
public class ClientService {
	

	// we need to autowire the Table from MySql
	@Autowired
	private ClientRepository clientRepository;
	
	// Return list of clients
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	// Save a new Client
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	// delete a client
	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<Client> findById(int id){
		return clientRepository.findById(id);
	}

}
