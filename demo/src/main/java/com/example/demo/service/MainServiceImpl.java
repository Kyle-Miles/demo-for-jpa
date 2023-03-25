package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Main;
import com.example.demo.repository.MainRepository;

@Service
public class MainServiceImpl implements MainService{
	
	private MainRepository mainRepository;
	
	@Autowired
	public MainServiceImpl(MainRepository mainRepository) {
		this.mainRepository = mainRepository;
	}

	@Override
	public Main saveMain(Main main) {
		return mainRepository.save(main);
	}

	@Override
	public List<Main> getAllMains() {
		return mainRepository.findAll();
	}

	@Override
	public Main getMainById(Long id) {
		return mainRepository.findById(id).orElseThrow(() -> 
	    	new ResourceNotFoundException("demo", "Id", id));
	}

	@Override
	public Main updateMain(Main main, Long id) {
		Main existingMain = mainRepository.findById(id).orElseThrow(() ->
	    new ResourceNotFoundException("demo", "Id", id));
	    
		existingMain.setMainString(main.getMainString());
		existingMain.setMainInt(main.getMainInt());
		
	    mainRepository.save(existingMain);
	    
	    return existingMain;
	}

	@Override
	public void deleteMain(Long id) {
		Main existingMain = mainRepository.findById(id).orElseThrow(() ->
	    new ResourceNotFoundException("demo", "Id", id));
	    
	    mainRepository.deleteById(id);
	}

}
