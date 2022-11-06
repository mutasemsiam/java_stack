package com.siam.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.siam.savetravels.models.Expense;
import com.siam.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// returns all the books
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a book
    public Expense createBook(Expense e) {
        return expenseRepository.save(e);
    }
    // retrieves a book
    public Expense findTravelExp(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // update a book
	public Expense updateTravel(Long id, String name, String vendor, double amount, String description) {
		// TODO Auto-generated method stub
		Expense editedExpense = findTravelExp(id);
		editedExpense.setName(name);
		editedExpense.setDescription(description);
		editedExpense.setVendor(vendor);
		editedExpense.setAmount(amount);
		
		return expenseRepository.save(editedExpense);
	}
	
}
