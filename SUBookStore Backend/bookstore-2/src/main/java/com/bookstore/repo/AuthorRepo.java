package com.bookstore.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Author;


@Repository
public interface AuthorRepo extends MongoRepository<Author, Integer>{
	
	public List<Author> findByAgeGreaterThan(int age);
	public List<Author> findByAgeLessThan(int age);
	public List<Author> findById(int id);
	public Author findByName(String name);
	public List<Author> FindByNameIgnoreCase(String name);
	public List<Author> FindByNameContainsIgnoreCase(String name);
	public List<Author> findAll();
	





}