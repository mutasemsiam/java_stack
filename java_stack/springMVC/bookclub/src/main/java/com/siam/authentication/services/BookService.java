package com.siam.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siam.authentication.models.Book;
import com.siam.authentication.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired 
	BookRepository bookRepo;
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteBook(Long id) {
		
		bookRepo.deleteById(id);
	}
	
	public Book updateBook(Book book) {

		return bookRepo.save(book);
	}
}
