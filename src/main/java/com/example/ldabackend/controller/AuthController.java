package com.example.ldabackend.controller;

import com.example.ldabackend.model.User;
import com.example.ldabackend.repository.UserRepository;
import com.example.ldabackend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    private UserRepository userRepository;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return Collections.singletonMap("error", "Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
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

        User user = userRepository.findByUsername(request.get("username")).get();
        String token = jwtUtil.generateToken(
                org.springframework.security.core.userdetails.User
                        .withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles("USER").build()
        );

        return Collections.singletonMap("token", token);
    }
}
