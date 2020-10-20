package com.codingdojo.budgeit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.budgeit.models.Expense;
import com.codingdojo.budgeit.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;
	
	//findAll
	
		public List<Expense> findAllExpenses(){
			return expenseRepository.findAll();
		}

	// find by id 
		public Expense findById(Long id) {
			Optional<Expense> myExpense = expenseRepository.findById(id);
			if (myExpense.isPresent()) {
				return myExpense.get();
			} else {
				return null;
			}
			
		}
		
		
		
		//create an expense
		
//		public Idea createIdea(Idea myIdea) {
//			return ideaRepository.save(myIdea);
//		}
		
		public Expense save(Expense expense) {
			return expenseRepository.save(expense);
		}
		
		
		//update expense
		
		public void updateExpense(Expense myExpense) {
			expenseRepository.save(myExpense);
		}
		
		
		//find expense by id
		public Expense findExpense(Long id) {
			Optional<Expense> optionalExpense = expenseRepository.findById(id);
			if(optionalExpense.isPresent()) {
				return optionalExpense.get();
			} else {
				return null;
			}
			
		}
		
		
		//delete an expense
		
		public void deleteExpense(Long id) {
			expenseRepository.deleteById(id);
		}

}
