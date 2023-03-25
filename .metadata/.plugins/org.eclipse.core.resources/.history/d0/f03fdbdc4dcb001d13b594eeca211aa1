package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demo;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/demo/demo")
public class DemoController {
	
	private DemoService demoService;
	
	@Autowired
	private DemoController(DemoService demoService) {
		super();
		this.demoService = demoService;
	}
	
	@PostMapping()
	public ResponseEntity<Demo> savePlayer(
			@RequestBody Demo demo) {
	    return new ResponseEntity<Demo>(demoService.saveDemo(demo),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity <List <Demo>> getAllDemos() {
	    return new ResponseEntity<List<Demo>>(demoService.getAllDemos(), HttpStatus.OK);
	}
	
	@GetMapping("{demo_id}")
	public ResponseEntity<Demo> getDemoById(
			@PathVariable("demo_id") Long id) {
		return new ResponseEntity<Demo>(demoService.getDemoById(id), HttpStatus.OK);
	}    
	
	@PutMapping("{demo_id}")
	public ResponseEntity<Demo> updateDemo(
			@PathVariable("demo_id") Long id,
			@RequestBody Demo demo) {
	    return new ResponseEntity<Demo>(demoService.updateDemo(demo, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{demo_id}")
	public ResponseEntity<String> deleteDemo(
			@PathVariable("demo_id") Long id) {
	    demoService.deleteDemo(id);
	    return new ResponseEntity<String>("Demo Deleted...", HttpStatus.OK);
	}
	

}
