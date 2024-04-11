package com.bookstore.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Customer {
	private String name;
	private String address;
	@Id
    private String id;
	@DBRef
	private List<Order> orders;
	
	public Customer() {
		
	}

	
	
	public Customer(String name, String address, List<Order> orders) {
		super();
		this.name = name;
		this.address = address;
		this.orders = orders;
	}



	//Might have to do ToString() @override
	public String getInfo() {
		String retVal = "Customer:\n";
		retVal+="Orders:\n";
		
		for (Order order : orders) {
			retVal+=order.getInfo();
		}
		
		retVal+= "The total of all orders is: " + getTotalOrdersAmount();
		retVal+="-------------\n";
		
		return retVal;
	}
	
	public double getTotalOrdersAmount() {
		double sum = 0;
		for (Order order : orders) {
			sum+=order.getTotalPrice();
		}
		return sum;
	}
	



	
	public List<Order> getOrders() {
		return orders;
	}



	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}