package com.siam.savetravels.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.siam.savetravels.models.Expense;
import com.siam.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	 
	  @GetMapping("/")
	    public String home() {
		return "redirect:/expenses";
	}
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
    
    @GetMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Expense expense = expenseService.findExpense(id);
    	model.addAttribute("expense",expense);
    	return "edit.jsp";
    }
    
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{expenseID}")
	public String show(Model model, @PathVariable("expenseID") Long myExpenseId) {
		Expense expense = expenseService.findExpense(myExpenseId);
		if (expense != null) {
			model.addAttribute("myExpense", expense);
			return "showOneExpense.jsp";
		} else {
			return "redirect:/expenses";
    
}
}
	   @DeleteMapping("/expenses/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        expenseService.deleteExpense(id);
	        return "redirect:/expenses";
	    }
}