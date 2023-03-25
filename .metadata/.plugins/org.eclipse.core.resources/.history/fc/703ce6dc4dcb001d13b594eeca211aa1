package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.example.demo.util.DemoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Demo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long demoId;
	
	private String demoString;
	
	private int demoInt;
	
	private boolean isDemo;
	
	@Enumerated(EnumType.STRING)
	private DemoEnum demoEnum;
	
	@ManyToMany
	@JoinTable(name = "demo_test",
	joinColumns = @JoinColumn(
			name = "demo_id"),
	inverseJoinColumns = {@JoinColumn(
			name = "test_id")})
	@JsonIgnore // this ignores the json for test fields so it doesn't combine results in swagger or postman, 
	//this is fine for testing but you may want to consider commenting @JsonIgnore out if you want to make use of the join table in swagger
	//this also applies to line 54 but that is for a foreign key reference example_id inside the demo table 
	private Set<Test> test = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name= "example_id")
	@JsonIgnore // see the above comments starting on line 47 to line 49
	private Example example;

}
