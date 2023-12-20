package com.example.ldabackend.repository;

import com.example.ldabackend.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
