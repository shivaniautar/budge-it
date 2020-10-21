package com.codingdojo.budgeit.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.budgeit.models.Budget;





@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long>{
	Budget findBudgetById(Long id);
//	List<Budget> findAll();

}
