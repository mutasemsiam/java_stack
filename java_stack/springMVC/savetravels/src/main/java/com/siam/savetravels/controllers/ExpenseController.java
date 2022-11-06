package com.siam.savetravels.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.siam.savetravels.models.Expense;
import com.siam.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	  @GetMapping("/expenses")
	    public String newTravel(@ModelAttribute("expense") Expense expense, Model model) {
		  model.addAttribute("allExpenses", expenseService.allExpenses());
	        return "index.jsp";
	    }
    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            expenseService.createBook(expense);
            return "redirect:/expenses";
        }
    }

}
