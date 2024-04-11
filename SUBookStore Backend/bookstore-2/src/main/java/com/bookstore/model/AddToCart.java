package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AddToCart {
	@Id 
	private String id;
	@DBRef
	private Book book;
	private int numberofbooks;
	public AddToCart() {
		
	}
	public AddToCart(Book book, int numberofbooks) {
		super();
		this.book = book;
		this.numberofbooks = numberofbooks;
	}
	
	
	
	public double getTotalPrice() {
		return book.getPrice() * numberofbooks;
	}
	
	//Might have to do ToString() with @override
	public String getInfo() {
		
		String retVal = "OrderBook: \n";
		retVal += book.getInfo();
		retVal += "Number of books: " + numberofbooks + "\n";
		retVal += "Total: " + getTotalPrice() + "\n/";
		return retVal;
	}
	
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNumberofbooks() {
		return numberofbooks;
	}
	public void setNumberofbooks(int numberofbooks) {
		this.numberofbooks = numberofbooks;
	}
	
	

}
