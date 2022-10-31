package com.siam.helloworld;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("")
	public String mainPage() {
		return "hello I'm Siam";
	}
	
	@RequestMapping("/hello")
	public String homePage() {
		return "Welcome!!! This is the home page";
	}

}

