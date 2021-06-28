package com.nt.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nt.entity.AuthenticationRequest;

public class MyUserDetails implements UserDetails{

	
	public AuthenticationRequest authenticationRequest;

	

	public MyUserDetails(AuthenticationRequest authenticationRequest) {
		super();
		this.authenticationRequest = authenticationRequest;
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authenticationRequest.getUsername());
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		return authenticationRequest.getPassword();
	}

	@Override
	public String getUsername() {
		
		return authenticationRequest.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
