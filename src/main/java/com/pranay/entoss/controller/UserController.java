package com.pranay.entoss.controller;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranay.entoss.entity.User;
import com.pranay.entoss.repository.UserRepository;
import com.pranay.entoss.service.UserServiceInterface;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServiceInterface.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userServiceInterface.getUserById(id);
    }

    @PostMapping("/adduser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userServiceInterface.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}