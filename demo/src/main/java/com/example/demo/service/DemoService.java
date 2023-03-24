package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Demo;

public interface DemoService {
	
	public Demo saveDemo(Demo demo);
	
	public List <Demo> getAllDemos();
	
	public Demo getDemoById(Long id);
	
	public Demo updateDemo(Demo demo, Long id);
	
	public void deleteDemo(Long id);

}
