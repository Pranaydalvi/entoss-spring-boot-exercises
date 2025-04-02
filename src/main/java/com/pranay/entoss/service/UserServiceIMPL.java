package com.pranay.entoss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pranay.entoss.entity.User;
import com.pranay.entoss.repository.UserRepository;
@Service
public class UserServiceIMPL implements UserServiceInterface{
	
	@Autowired
    private UserRepository userRepository;
	
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	public ResponseEntity<User> getUserById(Long id) {
	    Optional<User> userOptional = userRepository.findById(id);
	    
	    if (userOptional.isPresent()) {
	        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User authenticateUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Username or Password");
        }
    }
}
