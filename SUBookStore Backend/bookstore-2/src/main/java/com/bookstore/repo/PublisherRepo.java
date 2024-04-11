package com.bookstore.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Publisher;

@Repository
public interface PublisherRepo extends MongoRepository<Publisher, Integer>{
	
	public List<Publisher> findById(int id);
	public Publisher findByName(String name);
	public List<Publisher> FindByNameIgnoreCase(String name);
	public List<Publisher> FindByNameContainsIgnoreCase(String name);
	public Publisher findByCity(String city);
	public List<Publisher> FindByCityIgnoreCase(String city);
	public List<Publisher> FindByCityContainsIgnoreCase(String city);
	public List<Publisher> findAll();





}