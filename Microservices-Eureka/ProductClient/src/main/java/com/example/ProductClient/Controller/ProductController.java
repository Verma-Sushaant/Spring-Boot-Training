package com.example.ProductClient.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductClient.Service.ProductAsyncService;
import com.example.ProductClient.Service.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    private ProductAsyncService asyncService;
    @Autowired
    private ProductService service;

    @GetMapping("/get-product")
    public String getProduct() {
        asyncService.fetchProduct();
        return "Request Accepted. Product is being fetched\n " + service.getProductAddStatus();
    }
}
