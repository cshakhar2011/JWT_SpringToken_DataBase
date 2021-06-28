package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String username;
	private String password;
	private String roal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoal() {
		return roal;
	}
	public void setRoal(String roal) {
		this.roal = roal;
	}
	public HomeEntity(int id, String name, String username, String password, String roal) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.roal = roal;
	}
	public HomeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
