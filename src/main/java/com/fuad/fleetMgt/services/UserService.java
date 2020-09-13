package com.fuad.fleetMgt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.User;
import com.fuad.fleetMgt.repositories.UserRepository;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	
	@Autowired private BCryptPasswordEncoder encoder;
	
	public void save(User user) {
		// TODO Auto-generated method stub
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
