package com.fuad.fleetMgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fuad.fleetMgt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// Custom query
	User findByUsername(String username);
}
