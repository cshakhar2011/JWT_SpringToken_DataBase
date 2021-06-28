package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.HomeEntity;
import com.nt.repository.HomeRepository;

@Service
public class HomeService {

	@Autowired
	private HomeRepository homeRepository;

	public List<HomeEntity> getData() {
		// TODO Auto-generated method stub
		return this.homeRepository.findAll();
	}



	

	
	
	
	
}
