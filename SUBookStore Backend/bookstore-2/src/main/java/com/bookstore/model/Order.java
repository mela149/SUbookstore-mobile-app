package com.bookstore.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id
	private String id;
	@DBRef
	private List<AddToCart> items;
	private LocalDateTime date;
	@DBRef
	private Customer customer;
	
	
	public Order() {
		
	}


	public Order( List<AddToCart> items, LocalDateTime date, Customer customer) {
		super();
		this.items = items;
		this.date = date;
		this.customer = customer;
	}
	
	public double getTotalPrice() {
		
		double sum = 0;
		
		for (AddToCart addToCart : items) {
			sum+=addToCart.getTotalPrice();
		}
		
		return sum;
		
	}
	
	//Might have to do ToString() with @override
	public String getInfo() {
		String retVal = "Order: " + id + "\n";
		for (AddToCart addToCart : items) {
			retVal += addToCart.getInfo();
		}
		retVal += "\n-------------------\n";
		retVal += "Customer: " + customer.getName() + "\n";
		return retVal;
		
	}



	public List<AddToCart> getItems() {
		return items;
	}
	
	public void setItems(List<AddToCart> items) {
		this.items = items;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	

}