package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Publisher {
	@Id private String id;
	
	private String name;
	private String city;
	
	
	public Publisher(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}


	public Publisher(String id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}


	public Publisher() {
	}
	
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", city=" + city + "]\n";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	

}