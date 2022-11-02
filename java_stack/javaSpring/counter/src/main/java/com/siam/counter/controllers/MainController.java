package com.siam.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainController {
	   @RequestMapping("")
	   public String index(HttpSession session){
		   	
			if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
				}
				else {
					Integer currentCount = (Integer) session.getAttribute("count");
					currentCount ++;
					session.setAttribute("count", currentCount);
				}
			return "main.jsp";
		}
	   
	   @RequestMapping("/counter")
	   public String show(HttpSession session, Model model){
		   if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
				}
		   Integer currentCount = (Integer) session.getAttribute("count");
		   model.addAttribute("countToShow", currentCount);
			return "show.jsp";
		}
	   
	   @RequestMapping("/delete")
	   public String delete(HttpSession session){
		   session.invalidate();
			return "redirect:/your_server/counter";
		}
}
