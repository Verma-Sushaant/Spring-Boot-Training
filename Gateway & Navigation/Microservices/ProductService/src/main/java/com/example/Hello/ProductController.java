package com.example.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/products")
    public String getProducts() {
        return "I am from Products microservices";
    }
}