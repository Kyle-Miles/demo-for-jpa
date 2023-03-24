package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.util.ExampleEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Example {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long exampleId;
	
	private String exampleString;
	
	private int exampleInt;
	
	private boolean isExample;
	
	@Enumerated(EnumType.STRING)
	private ExampleEnum exampleEnum;
	
	@OneToMany(mappedBy = "example")
	private Set <Demo> demo;

}
