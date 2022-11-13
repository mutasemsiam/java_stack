package com.siam.bookbroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siam.bookbroker.models.Book;
import com.siam.bookbroker.models.User;
import com.siam.bookbroker.repositories.BookRepository;



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
	
	public List<Book> findBorrowedBook(User borrower) {
		return bookRepo.findByBorrower(borrower);
		
		}
	
	public List<Book> findUnBorrowedBook(Long id) {
		return bookRepo.findByBorrowerIdOrUserId(null, id);
		
		}
	
	
	public void deleteBook(Long id) {
		
		bookRepo.deleteById(id);
	}
	
	public Book updateBook(Book book) {

		return bookRepo.save(book);
	}
}
