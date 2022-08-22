package com.example.ldabackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("products")
    public List< Products > getUsers() {
        return this.productsRepository.findAll();
    }
}
