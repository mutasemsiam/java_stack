package com.siam.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class MainController {
	
	@RequestMapping(" ")
	public String index() {
		return "main.jsp";
	}
	
	@RequestMapping("/process")
	public String process(@RequestParam(value="number") String number,
	    	@RequestParam(value="city") String city, @RequestParam(value="person") String person,
	    	@RequestParam(value="hobby") String hobby, HttpSession mysession) {
		
		mysession.setAttribute("number", number);
		mysession.setAttribute("city", city);
		mysession.setAttribute("person", person);
		mysession.setAttribute("hobby", hobby);
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}

}
