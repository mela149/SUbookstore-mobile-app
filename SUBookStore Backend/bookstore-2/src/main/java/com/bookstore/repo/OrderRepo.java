package com.bookstore.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Order;


@Repository
public interface OrderRepo extends MongoRepository<Order, Integer>{
	
	public List<Order> findByDate(LocalDateTime date);;
	public List<Order> findById(int id);
	public List<Order> findBygetTotalPrice(double getTotalPrice);
	//public List<Order> findBy
	
	





}