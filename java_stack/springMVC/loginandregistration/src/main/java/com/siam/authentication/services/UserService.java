package com.siam.authentication.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.siam.authentication.models.LoginUser;
import com.siam.authentication.models.User;
import com.siam.authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findUserByEmail(String email) {
	     Optional<User> optionalDojo = userRepo.findByEmail(email);
	     if(optionalDojo.isPresent()) {
	         return optionalDojo.get();
	     } else {
	         return null;
	     }
	 }
	 public User findUserById(long id) {
	     Optional<User> optionalDojo = userRepo.findById(id);
	     if(optionalDojo.isPresent()) {
	         return optionalDojo.get();
	     } else {
	         return null;
	     }
	 }
	 public List<User> allUsers() {
	     return userRepo.findAll();
	 }
	 
	    public User register(User newUser, BindingResult result) {
	        
	    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
	    	
	    	// Reject if email is taken (present in database)
	    	if(potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "An account with this email already exists!");
	    	}
	    	
	        // Reject if password doesn't match confirmation
	    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
	    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	    	}
	    	
	    	// Reject if username contains anything other than letters
	    	String toCheckPattern = newUser.getUserName();
	    	if (!toCheckPattern.matches("[a-zA-Z]+")) {
	    		 result.rejectValue("userName", "Matches", "Username must contain letters only!");
			}
	    	
	    	// Reject if email pattern is incorrect
	    	String toCheckEmailPattern = newUser.getEmail();
	    	if (!toCheckEmailPattern.matches("[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}")) {
	    		 result.rejectValue("email", "Matches", "Please enter a valid email address!");
			}
	    	
	    	
	    	             
	    	// Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    
	        // Hash and set password, save user to database
	    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    	newUser.setPassword(hashed);
	    	return userRepo.save(newUser);
	    	
	    }
	    
	    public User login(LoginUser newLogin, BindingResult result) {
	    	
	    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
	        
	    	// Reject if email pattern is incorrect
	    	String toCheckEmailPattern = newLogin.getEmail();
	    	if (!toCheckEmailPattern.matches("[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{1,8}.[a-zA-Z.]{2,6}")) {
	    		 result.rejectValue("email", "Matches", "Please enter a valid email address!");
	    		 return null;
	    	}
	    	
	    	// Find user in the DB by email
	        // Reject if NOT present
	    	if(!potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "User not found!");
	    		return null;
	    	}
	    	
	    	// User exists, retrieve user from DB
	    	User user = potentialUser.get();
	        
	        // Reject if BCrypt password match fails
	    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    	    result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	    	
	    	// Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	
	        // Otherwise, return the user object
	        return user;
	    }
	
}
