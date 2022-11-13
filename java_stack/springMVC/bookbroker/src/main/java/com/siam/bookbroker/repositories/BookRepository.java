package com.siam.bookbroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.siam.bookbroker.models.Book;
import com.siam.bookbroker.models.User;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByUser(User user);
	List<Book> findByBorrower(User borrower);
	// This will retrieve all unborrowed books and the books that the current user created(posted)
	List<Book> findByBorrowerIdOrUserId(Long borrowerId, Long userId);

// Or instead of the last line, we can create the following query:
//	@Query(value = "SELECT * FROM books  WHERE borrower_id IS NULL OR user_id = ?1", 
//			  nativeQuery = true)
//	List<Book> getUnborrowedBooks(Long userId);
//
// And in BookService we put:
//	public List<Book> findUnBorrowedBook(Long id) {
//		return bookRepo.getUnborrowedBooks(id);
//		
//		}
	
}
