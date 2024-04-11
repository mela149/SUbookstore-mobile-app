package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
	@Id
	private String id;
	private String title;
	private int year;
	private double price;
	
	@DBRef
	private Author author;
	
	@DBRef
	private Publisher publisher;
	
	public Book() {
		
	}
	

	public String getInfo() {
		String retVal = "Title: " + title + "\n";
		retVal += "Price: " + price + "\n";
        retVal += "Year: " + year + "\n";
        retVal += author.toString();
        retVal += publisher.toString();
		return retVal;
		
	}
	
	
	public Book(String title, int year,double price, Author author, Publisher publisher) {
		super();
		this.title = title;
		this.year = year;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}


	public Book(String id, String title, int year, double price, Author author, Publisher publisher) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}
	
	
	
	

	public int getYear() {
		return year;
	}




	public void setYear(int year) {
		this.year = year;
	}




	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	
}