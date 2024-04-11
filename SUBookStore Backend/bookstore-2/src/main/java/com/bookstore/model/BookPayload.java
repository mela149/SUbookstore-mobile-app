package com.bookstore.model;

public class BookPayload {
	

	private String authorid;
	private String publisherid;
	private double price;
	private String title;
	private int year;
	
	public BookPayload() {
	}
	//public Book(String id, String title, int year, double price, Author author, Publisher publisher)
	public BookPayload(String title, int year,double price,String authorid, String publisherid) {
		super();
		this.authorid = authorid;
		this.price = price;
		this.publisherid = publisherid;
		this.title = title;
		this.year = year;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	public String getPublisherid() {
		return publisherid;
	}

	public void setPublisherid(String publisherid) {
		this.publisherid = publisherid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
	
}