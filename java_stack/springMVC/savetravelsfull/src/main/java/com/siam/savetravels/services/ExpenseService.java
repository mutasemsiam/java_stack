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
	
	// returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates an expense
    public Expense createBook(Expense e) {
        return expenseRepository.save(e);
    }
    // retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // update an expense
	public Expense updateExpense(Expense expense) {
		// TODO Auto-generated method stub
		Long expenseID = expense.getId();
		Expense editedExpense = findExpense(expenseID);
		editedExpense.setName(expense.getName());
		editedExpense.setDescription(expense.getDescription());
		editedExpense.setVendor(expense.getVendor());
		editedExpense.setAmount(expense.getAmount());
		
		return expenseRepository.save(editedExpense);
	}
	
	public void deleteExpense(Long id) {
		
		expenseRepository.deleteById(id);
		
	}
	
}
