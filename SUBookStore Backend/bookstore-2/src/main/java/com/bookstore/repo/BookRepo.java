package com.bookstore.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;

@Repository
public interface BookRepo extends MongoRepository<Book, String> {

    // Custom queries can be defined here
    
    public List<Book> findByTitle(String title);
    
    public List<Book> findByTitleIgnoreCase(String title);
    
    public List<Book> findByAuthor(String author);
    
    public List<Book> findByPublisher(String publisher);
    
    public List<Book> findByPriceLessThan(double price);
    
    public List<Book> findByPriceGreaterThan(double price);
    
    public List<Book> findByPriceBetween(double minPrice, double maxPrice);

    public List<Book> findAll();
    
    public List<Book> findById(int id);
    
    public List<Book> FindByTitleContainsIgnoreCase(String title);
    
    
}