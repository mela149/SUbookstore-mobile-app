package com.bookstore.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Customer;
import com.bookstore.model.Order;


@Repository
public interface CustomerRepo extends MongoRepository<Customer, Integer>{
	
	public List<Customer> findByNameContainsIgnoreCase(String name);
	public List<Customer> findById(int id);
	public List<Customer> findByOrder(Order orders);
	
	





}