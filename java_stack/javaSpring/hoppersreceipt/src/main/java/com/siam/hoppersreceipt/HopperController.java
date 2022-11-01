package com.siam.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HopperController {
	
	@RequestMapping("/")
	public String index(Model model) {
		
		 String name = "Mutasem Siam";
	     String itemName = "Mercedes G-Class";
	     double price = 200000;
	     String description = "a four-wheel drive automobile manufactured by Magna Steyr";
	     String vendor = "Little Things Corner Store";
	     
	     model.addAttribute("name", name);
	     model.addAttribute("item", itemName);
	     model.addAttribute("price", price);
	     model.addAttribute("desc", description);
	     model.addAttribute("vendor", vendor);
		return "index.jsp";
	}
}
