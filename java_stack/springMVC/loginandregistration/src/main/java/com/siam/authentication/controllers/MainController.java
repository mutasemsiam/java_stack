package com.siam.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.siam.authentication.models.LoginUser;
import com.siam.authentication.models.User;
import com.siam.authentication.services.UserService;

@Controller
public class MainController {
	
	
     @Autowired
     private UserService userService;
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	
        if(session.getAttribute("userId")!= null) {
        	return "redirect:/home";
        }
    	
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login_reg.jsp";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	if(session.getAttribute("userId") == null) {
			return "redirect:/";
    	}
    	
    	Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("currentUser", userService.findUserById(userId));
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
	 
	    return "redirect:/home";
	
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
    
        return "redirect:/home";
    }
    
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		session.invalidate();
	     
	    return "redirect:/";
	}
    
	
	
}
