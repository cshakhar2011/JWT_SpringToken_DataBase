package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.config.JwtUtil;
import com.nt.config.MyUserDetailsService;
import com.nt.entity.AuthenticationRequest;
import com.nt.entity.AuthenticationResponce;
import com.nt.entity.HomeEntity;
import com.nt.service.HomeService;

@RestController
public class HomeController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	
	@RequestMapping("/hello")
	public List<HomeEntity> getAllData() {
		return this.homeService.getData();
	}

	@PostMapping("/auth")
	public ResponseEntity<?> getresp(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			throw new Exception("Incrroct Username And Password.."+e);
		}
		
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String generateToken = jwtUtil.generateToken(userDetails);
		System.out.println(generateToken);
		AuthenticationResponce responce_token = new AuthenticationResponce(generateToken);
		System.out.println(responce_token);
		return ResponseEntity.ok(responce_token);
	}

}
