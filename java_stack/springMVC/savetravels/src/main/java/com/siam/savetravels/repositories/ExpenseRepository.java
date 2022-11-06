package com.siam.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.siam.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	List<Expense> findAll();
}
