package com.codingdojo.budgeit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.budgeit.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findUserById(Long id);
	User findByEmail(String email);

}
