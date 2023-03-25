package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.One;
import com.example.demo.repository.OneRepository;

@Service
public class OneServiceImpl implements OneService{
	
	private OneRepository oneRepository;
	
	@Autowired
	public OneServiceImpl(OneRepository oneRepository) {
		this.oneRepository = oneRepository;
	}

	@Override
	public One saveOne(One one) {
		return oneRepository.save(one);
	}

	@Override
	public List<One> getAllOne() {
		return oneRepository.findAll();
	}

	@Override
	public One getOneById(Long id) {
		return oneRepository.findById(id).orElseThrow(() -> 
    		new ResourceNotFoundException("demo", "Id", id));
	}

	@Override
	public One updateOne(One one, Long id) {
		One existingOne = oneRepository.findById(id).orElseThrow(() ->
	    new ResourceNotFoundException("demo", "Id", id));
	    
		existingOne.setOne(one.isOne());
		
	    oneRepository.save(existingOne);
	    
	    return existingOne;
	}

	@Override
	public void deleteOne(Long id) {
		One existingOne = oneRepository.findById(id).orElseThrow(() ->
	    new ResourceNotFoundException("demo", "Id", id));
	    
	    oneRepository.deleteById(id);
		
	}

}
