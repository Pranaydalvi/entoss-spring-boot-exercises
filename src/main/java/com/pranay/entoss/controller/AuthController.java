package com.pranay.entoss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pranay.entoss.entity.User;
import com.pranay.entoss.security.JwtUtil;
import com.pranay.entoss.service.UserServiceInterface;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        User user = userServiceInterface.authenticateUser(username, password);
        String token = jwtUtil.generateToken(username);
        
        return ResponseEntity.ok(token);
    }
}