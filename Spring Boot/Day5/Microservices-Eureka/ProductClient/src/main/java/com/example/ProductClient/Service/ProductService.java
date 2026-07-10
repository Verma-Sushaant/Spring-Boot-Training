package com.example.ProductClient.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
    RestTemplate restTemplate;
    public String getProductAddStatus() {
        return restTemplate.getForObject("http://localhost:9009/cart/product-status", String.class);
    }
}