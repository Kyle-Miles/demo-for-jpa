package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Many;

public interface ManyService {

	public Many saveMany(Many many);
	
	public List <Many> getAllMany();
	
	public Many getManyById(Long id);
	
	public Many updateMany(Many many, Long id);
	
	public void deleteMany(Long id);
}
