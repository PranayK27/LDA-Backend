package com.example.ldabackend.controller;

import com.example.ldabackend.model.Login;
import com.example.ldabackend.repository.LoginRepository;
import com.example.ldabackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public HttpStatus login(@RequestBody Login login) {
        Long id = login.getId();
        String username = login.getUsername();
        String password = login.getPassword();

        if (loginService.authenticateUser(id, username, password)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
