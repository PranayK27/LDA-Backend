package com.example.ldabackend.service;

import com.example.ldabackend.model.Login;
import com.example.ldabackend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Value("${login.default.username}")
    private String defaultUsername;

    @Value("${login.default.password}")
    private String defaultPassword;

    public boolean authenticateUser(String username, String password) {
        if (defaultUsername.equals(username) && defaultPassword.equals(password)) {
            return true;
        }

        Login login = loginRepository.findByUsername(username);

        // Add your authentication logic here
        return login != null && login.getPassword().equals(password);
    }
}
