package com.siam.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/daikichi")
public class HomeController {
	
	@RequestMapping("/travel/{city}")
	public String home(@PathVariable("city") String myCity) {
		return "Welcome in " + myCity;
	}
	
	@RequestMapping("/try/{number}")
	public String todayMessage(@PathVariable("number") int myNumber) {
		if (myNumber%2==0) {
			return "This is an even number";
		}
		
		else {
			return "This is an odd number";
		}
		
		
	}
	

}
