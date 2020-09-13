package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Contact;
import com.fuad.fleetMgt.repositories.ContactRepository;

@Service
public class ContactService {


	// we need to autowire the Table from MySql
	@Autowired
	private ContactRepository contactRepository;
	
	// Return list of contacts
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	// Save a new Contact
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	
	// delete a contact
	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<Contact> findById(int id){
		return contactRepository.findById(id);
	}

}
