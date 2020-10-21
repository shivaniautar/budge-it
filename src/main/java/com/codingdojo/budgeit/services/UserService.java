package com.codingdojo.budgeit.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.budgeit.models.User;
import com.codingdojo.budgeit.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository;
    
    public List<User> allUsers(){
		return (List<User>) userRepository.findAll();
	}
    public User createUser(User user) {
    	return userRepository.save(user);
    }
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    public void deleteUser(Long id) {
		userRepository.deleteById(id);	
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
