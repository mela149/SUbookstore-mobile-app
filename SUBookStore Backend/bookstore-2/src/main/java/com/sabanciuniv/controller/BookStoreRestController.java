package com.sabanciuniv.controller;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.model.BookPayload;
import com.bookstore.model.Publisher;
import com.bookstore.repo.AuthorRepo;
import com.bookstore.repo.BookRepo;
import com.bookstore.repo.PublisherRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.model.BookPayload;
import com.bookstore.model.Publisher;
import com.bookstore.repo.AuthorRepo;
import com.bookstore.repo.BookRepo;
import com.bookstore.repo.PublisherRepo;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/bookstore-2")
public class BookStoreRestController {
	
	@Autowired private AuthorRepo authorrepo;
	@Autowired private BookRepo bookrepo;
	@Autowired private PublisherRepo publisherrepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BookStoreRestController.class);
	
	@PostConstruct
	public void init() {
		
		if(publisherrepo.count() ==0) {
			logger.info("Database is empty, initializing..");
			Publisher pub1 = new Publisher("Oxford", "Oxford City");
			Publisher pub2 = new Publisher("Cambridge", "Cambridge City");
			Publisher pub3 = new Publisher("Penguin", "London");
			
			publisherrepo.save(pub1);
			publisherrepo.save(pub2);
			publisherrepo.save(pub3);
			
			Author a1 = new Author("author1","one");
			Author a2 = new Author("author2","two");
			Author a3 = new Author("author3","three");
			
			authorrepo.save(a1);
			authorrepo.save(a2);
			authorrepo.save(a3);
			
			
			
			List<Author> authors = authorrepo.findAll();
			List<Publisher> pubs = publisherrepo.findAll();
			
			
			Book b1 = new Book("Book 1", 2022,12, authors.get(0), pubs.get(0));
			Book b2 = new Book("Book 2", 1999,15, authors.get(1), pubs.get(1));
			Book b3 = new Book("Book 3", 2000,17, authors.get(2), pubs.get(2));
			Book b4 = new Book("Book 4", 2020,18, authors.get(0), pubs.get(0));
			Book b5 = new Book("Book 5", 2022,20, authors.get(1), pubs.get(2));
			
			bookrepo.save(b1);
			bookrepo.save(b2);
			bookrepo.save(b3);
			bookrepo.save(b4);
			bookrepo.save(b5);
			
			logger.info("All sample data saved!");
			
			

		}
		
		
		
	}
	
	
	@GetMapping("/author")
	public List<Author> authors(){
		return authorrepo.findAll();
	}
	
	@PostMapping("/author/save")
	public Author saveAuthor(@RequestBody Author author) {
		
		Author authorSaved = authorrepo.save(author);
		return authorSaved;
		
	}
	
	
	
	
	@GetMapping("/publisher")
	public List<Publisher> publishers(){
		return publisherrepo.findAll();
	}
	@PostMapping("/publisher/save")
	public Publisher savePublisher(@RequestBody Publisher publisher) {
		
		Publisher publisherSaved = publisherrepo.save(publisher);
		return publisherSaved;
		
	}
	
	
	@GetMapping("/book")
	public List<Book> books(){
		return bookrepo.findAll();
	}
	@PostMapping("/book/search")
	public List<Book> searchBooks(@RequestBody BookPayload payload){
		
		List<Book> books=
				bookrepo.FindByTitleContainsIgnoreCase(payload.getTitle());
		
		return books;
	}
	@PostMapping("/book/save")
	public Book saveBook(@RequestBody BookPayload payload)
	{
		//Author auth = authorRepository.findById(payload.getAuthorid()).get();
		
		Author auth = new Author();
		auth.setId(payload.getAuthorid());
		
		Publisher pub = new Publisher();
		pub.setId(payload.getPublisherid());
		
		
		Book bookToSave = new Book(payload.getTitle(), payload.getYear(),  payload.getPrice(), auth, pub);
		//String id, String title, int year, double price, Author author, Publisher publisher
		Book bookSaved= bookrepo.save(bookToSave);
		
		return bookSaved;
		
	}

}