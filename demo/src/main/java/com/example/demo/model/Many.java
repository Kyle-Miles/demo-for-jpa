package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.example.demo.util.ManyEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Many {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long manyId;
	
	@Enumerated(EnumType.STRING)
	private ManyEnum manyEnum;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "many")
	private Set <Main> main;
	
	@ManyToOne
	@JoinColumn(name= "one_id")
	private One one;

}
