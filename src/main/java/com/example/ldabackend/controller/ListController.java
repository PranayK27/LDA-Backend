package com.example.ldabackend.controller;

import com.example.ldabackend.model.TechnologyList;
import com.example.ldabackend.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class ListController {

    @Autowired
    private ListRepository listRepository;

    @GetMapping("/list")
    public java.util.List<TechnologyList> getUsers() {
        return this.listRepository.findAll();
    }
}
