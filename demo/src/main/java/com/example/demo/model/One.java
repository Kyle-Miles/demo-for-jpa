package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class One {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long oneId;
	
	private boolean isOne;
	
	@JsonIgnore
	@OneToMany(mappedBy = "one")
	private Set <Many> many;

}
