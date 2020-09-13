package com.fuad.fleetMgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.fuad.fleetMgt.models.Client;
import com.fuad.fleetMgt.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
