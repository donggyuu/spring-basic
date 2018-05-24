package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;;


@Data
@Entity
public class Country {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String capital;
	
	public Country() {
		
	}
	
	public Country(String name, String capital) {
		super();
		this.name = name;
		this.capital = capital;
	}
}
