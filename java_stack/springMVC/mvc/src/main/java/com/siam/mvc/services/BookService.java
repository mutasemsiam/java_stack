package com.siam.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.siam.mvc.models.Book;
import com.siam.mvc.repositories.BookRepository;

@Service 
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepository = bookRepo;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // update a book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Book editedBook = findBook(id);
		editedBook.setTitle(title);
		editedBook.setDescription(desc);
		editedBook.setLanguage(lang);
		editedBook.setNumberOfPages(numOfPages);
		
		return bookRepository.save(editedBook);
	}

	public void deleteBook(Long id) {
		
		bookRepository.deleteById(id);
		
	}

}
