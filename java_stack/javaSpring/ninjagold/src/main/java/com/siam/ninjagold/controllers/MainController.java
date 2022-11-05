package com.siam.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
		if(session.getAttribute("totalGold") == null) {
			session.setAttribute("totalGold", 0);
		}
		ArrayList<String> messages = new ArrayList<String>();
		if(session.getAttribute("messages") == null) {
			session.setAttribute("messages", messages);
		}
		model.addAttribute("totalGold",session.getAttribute("totalGold"));
		model.addAttribute("messages",session.getAttribute("messages"));
		
		
		return "index.jsp";
	}
	
	@PostMapping("/process_money")
	public String findGold(@RequestParam(value="goldGame") String goldGame, HttpSession session) {
		Random randomNumber = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd Y h:mma");
		
		
		ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
		int goldReceived;
		
		if(goldGame.equals("farm") || goldGame.equals("cave") || goldGame.equals("house") ) {
			goldReceived = (randomNumber.nextInt(10,20));
			messages.add(String.format("You entered a %s and earned %d gold %s ",goldGame,goldReceived,formatter.format(now)));
		} 
		else if(goldGame.equals("quest")) {
			goldReceived = (randomNumber.nextInt(-50,50));
			if(goldReceived < 0) {
				messages.add(String.format("You entered a quest and lost %d gold. Ouch %s</p>",-goldReceived,formatter.format(now)));
			}
			else {
				messages.add(String.format("You entered a quest and earned %d gold %s",goldReceived,formatter.format(now)));
			}
		} 
		else {
			System.out.println("/");
			return "redirect:/";
		}
		int gold= (int)session.getAttribute("totalGold");
		int totalGold = gold + goldReceived;
		session.setAttribute("totalGold", totalGold);
		session.setAttribute("showMessages", messages);
//		Collections.sort(messages);
		return "redirect:/";
		
	}
	
	   @RequestMapping("/delete")
	   public String delete(HttpSession session){
		   session.invalidate();
			return "redirect:/";
		}
}
