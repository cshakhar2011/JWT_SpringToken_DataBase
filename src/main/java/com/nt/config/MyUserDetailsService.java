package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nt.entity.AuthenticationRequest;
import com.nt.repository.AuthEntity;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthEntity authEntity;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AuthenticationRequest userByName = authEntity.getUserByName(username);
		if(userByName==null)
		{
			throw new UsernameNotFoundException("UserNmae is Not Found...");
		}
		MyUserDetails authenticationRequest = new MyUserDetails(userByName);
		
		
		
		
		return authenticationRequest;
	}
	
	


}
