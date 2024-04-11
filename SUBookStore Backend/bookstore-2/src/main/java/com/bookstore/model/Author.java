package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Author {
	@Id private String id;
	
	private String name;
	private String lastName;
	
	
	public Author() {
		super();
	}


	public Author(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}


	public Author(String id, String name, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", lastName=" + lastName + "]\n";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public String getId() {
		return id;
	}
	public void setId(String authorid) {
		
	}
	
	
	

}