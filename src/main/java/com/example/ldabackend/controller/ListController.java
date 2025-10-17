package com.example.ldabackend.controller;

import com.example.ldabackend.model.TechnologyList;
import com.example.ldabackend.repository.ListRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class ListController {

    private ListRepository listRepository;

    @GetMapping("/list")
    public java.util.List<TechnologyList> getUsers() {
        return this.listRepository.findAll();
    }
}
