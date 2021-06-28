package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.AuthenticationRequest;



public interface AuthEntity extends JpaRepository<AuthenticationRequest, Integer> {
	
	@Query("select u from AuthenticationRequest u where u.username=:username")
	public AuthenticationRequest getUserByName(@Param("username")String username);

}
