package com.codingdojo.budgeit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.budgeit.models.Budget;
import com.codingdojo.budgeit.repositories.BudgetRepository;

@Service
public class BudgetService {
	@Autowired
	BudgetRepository budgetRepository;
	
	
	//findAll
	
//	public List<Budget> findAllBudgets(){
//		return budgetRepository.findAll();
//	}

// find by id 
	public Budget findById(Long id) {
		Optional<Budget> myBudget = budgetRepository.findById(id);
		if (myBudget.isPresent()) {
			return myBudget.get();
		} else {
			return null;
		}
		
	}
	
	
	
	//create a budget
	
//	public Idea createIdea(Idea myIdea) {
//		return ideaRepository.save(myIdea);
//	}
	
	public Budget save(Budget budget) {
		return budgetRepository.save(budget);
	}
	
	
	//update budget
	
	public void updateBudget(Budget myBudget) {
		budgetRepository.save(myBudget);
	}
	
	
	//find budget by id
	public Budget findBudget(Long id) {
		Optional<Budget> optionalBudget = budgetRepository.findById(id);
		if(optionalBudget.isPresent()) {
			return optionalBudget.get();
		} else {
			return null;
		}
		
	}
	
	
	//delete an budget
	
	public void deleteBudget(Long id) {
		budgetRepository.deleteById(id);
	}

}
