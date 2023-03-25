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

import com.example.demo.model.One;
import com.example.demo.service.OneService;

@RestController
@RequestMapping("/demo/one")
public class OneController {
	
	private OneService demoService;
	
	@Autowired
	private OneController(OneService demoService) {
		super();
		this.demoService = demoService;
	}
	
	@PostMapping()
	public ResponseEntity<One> save(
			@RequestBody One one) {
	    return new ResponseEntity<One>(demoService.saveOne(one),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity <List <One>> getAll() {
	    return new ResponseEntity<List<One>>(demoService.getAllOne(), HttpStatus.OK);
	}
	
	@GetMapping("{one_id}")
	public ResponseEntity<One> getById(
			@PathVariable("one_id") Long id) {
		return new ResponseEntity<One>(demoService.getOneById(id), HttpStatus.OK);
	}    
	
	@PutMapping("{one_id}")
	public ResponseEntity<One> update(
			@PathVariable("one_id") Long id,
			@RequestBody One one) {
	    return new ResponseEntity<One>(demoService.updateOne(one, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{one_id}")
	public ResponseEntity<String> delete(
			@PathVariable("one_id") Long id) {
	    demoService.deleteOne(id);
	    return new ResponseEntity<String>("Demo Deleted...", HttpStatus.OK);
	}

}
