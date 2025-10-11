package com.example.ldabackend.controller;

import com.example.ldabackend.model.User;
import com.example.ldabackend.repository.UserRepository;
import com.example.ldabackend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private UserRepository userRepo;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            return Collections.singletonMap("error", "Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return Collections.singletonMap("message", "User registered successfully");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.get("username"), request.get("password")));
        } catch (BadCredentialsException e) {
            return Collections.singletonMap("error", "Invalid credentials");
        }

        User user = userRepo.findByUsername(request.get("username")).get();
        String token = jwtUtil.generateToken(
                org.springframework.security.core.userdetails.User
                        .withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles("USER").build()
        );

        // 👇 Return a JSON response containing the token
        return Collections.singletonMap("token", token);
    }
}
