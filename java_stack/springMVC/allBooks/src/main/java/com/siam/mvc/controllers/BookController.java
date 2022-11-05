package com.siam.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siam.mvc.models.Book;
import com.siam.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService myBookService;

	@RequestMapping("/books")
	public String index(Model model) {
		
		List <Book> books = myBookService.allBooks();
		model.addAttribute("allBooks", books);
		
		return "index.jsp";
	}
	
	@RequestMapping("/books/{bookID}")
	public String index(Model model, @PathVariable("bookID") Long myBookID) {
		Book myBook = myBookService.findBook(myBookID);
		if (myBook != null) {
		model.addAttribute("myOwnBook", myBook);
		return "showOneBook.jsp";
		}
		else {
		return "redirect:/books";
		}
	}
}
