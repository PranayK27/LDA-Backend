package com.example.ldabackend.controller;

import com.example.ldabackend.dto.LoginRequestDTO;
import com.example.ldabackend.model.Login;
import com.example.ldabackend.repository.LoginRepository;
import com.example.ldabackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v2")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/cred")
    public java.util.List<Login> getUsers() {
        return this.loginRepository.findAll();
    }

    @PostMapping()
    public String login(@RequestBody LoginRequestDTO loginRequestDTO) {
        String username = loginRequestDTO.getUsername();
        String password = loginRequestDTO.getPassword();

        if (loginService.authenticateUser(username, password)) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }
}
