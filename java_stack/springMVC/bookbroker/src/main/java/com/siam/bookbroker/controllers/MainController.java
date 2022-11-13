package com.siam.bookbroker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.siam.bookbroker.models.Book;
import com.siam.bookbroker.models.LoginUser;
import com.siam.bookbroker.models.User;
import com.siam.bookbroker.services.BookService;
import com.siam.bookbroker.services.UserService;



	@Controller
	public class MainController {
		
		
	     @Autowired
	     UserService userService;
	     @Autowired
	     BookService bookService;
	     
	     
	    @GetMapping("/")
	    public String index(Model model, HttpSession session) {
	    	
	        if(session.getAttribute("userId")!= null) {
	        	return "redirect:/books";
	        }
	    	
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "login_reg.jsp";
	    }
	    
	    @GetMapping("/books")
	    public String home(HttpSession session, Model model) {
	    	if(session.getAttribute("userId") == null) {
				return "redirect:/";
	    	}
	    	
	    	Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("currentUser", userService.findUserById(userId));
			model.addAttribute("allBooks", bookService.allBooks());
			User thisUser = userService.findUserById(userId);
			model.addAttribute("borrowedBooks", bookService.findBorrowedBook(thisUser));
			model.addAttribute("unborrowedbooks", bookService.findUnBorrowedBook(userId));
	    	return "home.jsp";
	    }
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser,
	    		               BindingResult result, HttpSession session, Model model) {
		     
			User user = userService.register(newUser, result);
			
		    if(result.hasErrors()) {
		        model.addAttribute("newLogin", new LoginUser());
		        return "login_reg.jsp";
		    }
		    
		    session.setAttribute("userId", user.getId());
		 
		    return "redirect:/books";
		
	        }

	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	                        BindingResult result, Model model, HttpSession session) {
	        
	       
	         User user = userService.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "login_reg.jsp";
	        }
	    
	        session.setAttribute("userId", user.getId());
	    
	        return "redirect:/books";
	    }
	    
		@GetMapping("/logout")
		public String logout(HttpSession session) {
		 
			session.invalidate();
		     
		    return "redirect:/";
		}
		
		@GetMapping("/books/new")
		public String newBook(@ModelAttribute("newBook") Book book,
				HttpSession session, Model model) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
	    	}

			return"add_book.jsp";
			
		}
	    @PostMapping("/books/new")
	    public String createNewBook(@Valid @ModelAttribute("newBook") Book book,
	    		BindingResult result) {
	    	if (result.hasErrors()) {
	            return "add_book.jsp";
	        } else {
	        	System.out.println("hi");
	            bookService.createBook(book);
	          
	            return "redirect:/books";
	    }
	    
	    }
	    
	    @GetMapping("/books/{bookId}")
	    public String showBook(@PathVariable("bookId") Long bId, Model model,
	    		HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
				return "redirect:/";
	    	}
	    	model.addAttribute("thisBook", bookService.findBook(bId));
	    	return "one_book.jsp";
	    }
	    
	    @GetMapping("/delete/{bookId}")
	    public String deleteBook(@PathVariable("bookId") Long bId, HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
				return "redirect:/";
	    	}
	    	Book book = bookService.findBook(bId);
	    	if(session.getAttribute("userId")==book.getUser().getId()) {
	    	bookService.deleteBook(bId);
	    	}
	    	return "redirect:/books";
	    }
	    
	    @GetMapping("/books/{bookId}/edit")
	    public String editBook(@PathVariable("bookId") Long id, Model model) {
	    Book book = bookService.findBook(id);
	    model.addAttribute("thisBook", book);
	    return "edit_book.jsp";
	    }


		@PutMapping("/books/{id}")
		public String update(@Valid @ModelAttribute("thisBook") Book book,
				BindingResult result, @PathVariable("id") Long id) {
			if (result.hasErrors()) {
				return "edit_book.jsp";
			} else {
				Book thisBook = bookService.findBook(id);
				User borrower = thisBook.getBorrower();
				book.setBorrower(borrower);
				bookService.updateBook(book);
				return "redirect:/books/" + id;
			}
		}
		
		@GetMapping("/borrow/{bookId}")
		public String borrow(HttpSession session, @PathVariable("bookId") Long bId) {
			Long userId = (Long) session.getAttribute("userId");
			User thisUser = userService.findUserById(userId);
			Book thisBook = bookService.findBook(bId);
			thisBook.setBorrower(thisUser);
			thisUser.getBorrowedBooks().add(thisBook);
			bookService.updateBook(thisBook);
			
			return "redirect:/books";
		}
		
		@GetMapping("/return/{bookId}")
		public String returnBook(HttpSession session, @PathVariable("bookId") Long bId) {
			Long userId = (Long) session.getAttribute("userId");
			User thisUser = userService.findUserById(userId);
			Book thisBook = bookService.findBook(bId);
			thisBook.setBorrower(null);
			thisUser.getBorrowedBooks().remove(thisBook);
			thisUser.getBorrowedBooks().add(thisBook);
			bookService.updateBook(thisBook);
			return "redirect:/books";
		}
}
