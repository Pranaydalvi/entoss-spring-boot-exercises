package com.pranay.entoss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.pranay.entoss.entity.User;

public interface UserServiceInterface {
	List<User> getAllUsers();
    ResponseEntity<User> getUserById(Long id);
    User createUser(User user);
    User authenticateUser(String username, String password);
}