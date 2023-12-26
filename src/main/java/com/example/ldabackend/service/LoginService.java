package com.example.ldabackend.service;

import com.example.ldabackend.model.Login;
import com.example.ldabackend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Value("${login.default.id}")
    private Long defaultId;

    @Value("${login.default.username}")
    private String defaultUsername;

    @Value("${login.default.password}")
    private String defaultPassword;

    public boolean authenticateUser(Long id, String username, String password) {
        if (defaultId.equals(id) && defaultUsername.equals(username) && defaultPassword.equals(password)) {
            return true;
        }

        Login login = loginRepository.findByUsername(username);

        // Add your authentication logic here
        return login != null && login.getPassword().equals(password);
    }
}
