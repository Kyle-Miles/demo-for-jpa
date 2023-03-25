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

import com.example.demo.model.Many;
import com.example.demo.service.ManyService;

@RestController
@RequestMapping("/demo/many")
public class ManyController {
	
	private ManyService demoService;
	
	@Autowired
	private ManyController(ManyService demoService) {
		super();
		this.demoService = demoService;
	}
	
	@PostMapping()
	public ResponseEntity<Many> save(
			@RequestBody Many main) {
	    return new ResponseEntity<Many>(demoService.saveMany(main),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity <List <Many>> getAll() {
	    return new ResponseEntity<List<Many>>(demoService.getAllMany(), HttpStatus.OK);
	}
	
	@GetMapping("{many_id}")
	public ResponseEntity<Many> getById(
			@PathVariable("many_id") Long id) {
		return new ResponseEntity<Many>(demoService.getManyById(id), HttpStatus.OK);
	}    
	
	@PutMapping("{many_id}")
	public ResponseEntity<Many> update(
			@PathVariable("many_id") Long id,
			@RequestBody Many many) {
	    return new ResponseEntity<Many>(demoService.updateMany(many, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{many_id}")
	public ResponseEntity<String> delete(
			@PathVariable("many_id") Long id) {
	    demoService.deleteMany(id);
	    return new ResponseEntity<String>("Demo Deleted...", HttpStatus.OK);
	}

}
