package com.siam.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	@RequestMapping("/")
	public String hello(@RequestParam(value="name", required=false) String searchQuery1, @RequestParam(value="times", required=false) String searchQuery3,
			@RequestParam(value="last_name", required=false) String searchQuery2) {
		// TODO Auto-generated method stub
		if (searchQuery1 == null && searchQuery2 ==null && searchQuery3==null) {
		return "Hello Human";
		}
		
		else if (searchQuery2 ==null && searchQuery3==null) {
			return "Hello " + searchQuery1;
		}

		else if (searchQuery1==null && searchQuery3==null) {
			return "Hello " + searchQuery2; 
		}

		else if (searchQuery3 ==null) {
			return "Hello " + searchQuery1 + " " + searchQuery2;
			
		}
		else if(searchQuery1==null && searchQuery2==null) {
			String str = "Hello ";
			String repeat = str.repeat(Integer.parseInt(searchQuery3));
			
			return repeat;
		
		}
		else if (searchQuery2 ==null) {
			
			String str = "Hello " + searchQuery1  + " ";
			String repeat = str.repeat(Integer.parseInt(searchQuery3));
			
			return repeat;
		}
		
		else if(searchQuery1==null){
			
			String str = "Hello "  + " " + searchQuery2 + " ";
			String repeat = str.repeat(Integer.parseInt(searchQuery3));
			
			return repeat;
		}
		
		else{
			
			String str = "Hello " + searchQuery1  + " " + searchQuery2 + " ";
			String repeat = str.repeat(Integer.parseInt(searchQuery3));
			
			return repeat;
		}
	}
	

}
