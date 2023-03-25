package com.example.demo.service;

import java.util.List;

import com.example.demo.model.One;

public interface OneService {
	
	public One saveOne(One one);
	
	public List <One> getAllOne();
	
	public One getOneById(Long id);
	
	public One updateOne(One one, Long id);
	
	public void deleteOne(Long id);

}
