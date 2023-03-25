package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService{
	
	private DemoRepository demoRepository;
	
	@Autowired
	public DemoServiceImpl(DemoRepository demoRepository) {
		this.demoRepository = demoRepository;
	}

	@Override
	public Demo saveDemo(Demo demo) {
		return demoRepository.save(demo);
	}

	@Override
	public List<Demo> getAllDemos() {
		return demoRepository.findAll();
	}

	@Override
	public Demo getDemoById(Long id) {
		return demoRepository.findById(id).orElseThrow(() -> 
	    	new ResourceNotFoundException("player", "Id", id));
	}

	@Override
	public Demo updateDemo(Demo demo, Long id) {
		Demo existingDemo = demoRepository.findById(id).orElseThrow(() ->
	    new ResourceNotFoundException("demo", "Id", id));
	    
		existingDemo.setDemoString(demo.getDemoString());
		existingDemo.setDemoInt(demo.getDemoInt());
		existingDemo.setDemo(demo.isDemo());
		existingDemo.setDemoEnum(demo.getDemoEnum());
		existingDemo.setExample(demo.getExample());
		existingDemo.setTest(demo.getTest());
		
	    demoRepository.save(existingDemo);
	    return existingDemo;
	}

	@Override
	public void deleteDemo(Long id) {
		Demo existingDemo = demoRepository.findById(id).orElseThrow(() ->
	    new ResourceNotFoundException("demo", "Id", id));
	    
	    demoRepository.deleteById(id);
	}

}
