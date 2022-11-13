package com.siam.bookbroker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="books")
public class Book {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	@NotEmpty(message="Title is required!")
	    @Size(min=2, max=30, message="Title must be between 2 and 30 characters")
	    private String title;
	 	
	 	@NotEmpty(message="Author is required!")
	    @Size(min=2, max=30, message="Author name must be between 2 and 30 characters")
	    private String author;
	 	
	 	@NotEmpty(message="Please enter your thoughts about this book!")
	    @Size(min=8, max=200, message="You must write between 8 and 200 characters")
	    private String thoughts;
	 	
	 	@Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="borrower_id")
	    private User borrower;

		public Book() {
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getThoughts() {
			return thoughts;
		}

		public void setThoughts(String thoughts) {
			this.thoughts = thoughts;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public User getBorrower() {
			return borrower;
		}

		public void setBorrower(User borrower) {
			this.borrower = borrower;
		}
		
		
}