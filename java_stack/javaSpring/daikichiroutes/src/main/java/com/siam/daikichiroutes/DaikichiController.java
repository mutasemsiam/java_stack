package com.siam.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {

	@RequestMapping("")
	public String home() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String todayMessage() {
		return "Today is a good day";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrowMessage() {
		return "Tomorrow will be a good day";
	}
}
