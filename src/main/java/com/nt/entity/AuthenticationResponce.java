package com.nt.entity;

public class AuthenticationResponce {

	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticationResponce(String token) {
		super();
		this.token = token;
	}

	public AuthenticationResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
