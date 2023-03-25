package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Main;

public interface MainService {
	
	public Main saveMain(Main main);
	
	public List <Main> getAllMains();
	
	public Main getMainById(Long id);
	
	public Main updateMain(Main main, Long id);
	
	public void deleteMain(Long id);

}
