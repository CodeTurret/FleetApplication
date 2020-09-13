package com.fuad.fleetMgt;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// This class is used for returning logged in User
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
		// this "username" is the logged in user
		String username = authentication.getName();	
		
		return Optional.ofNullable(username).filter(s -> !s.isEmpty());
	
	}

}
