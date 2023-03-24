package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.demo.util.TestEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Test {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long testId;
	
	private String testString;
	
	private int testInt;
	
	private boolean isTest;
	
	@Enumerated(EnumType.STRING)
	private TestEnum testEnum;
	
	@ManyToMany(mappedBy = "test")
	private Set <Demo> demo;

}
