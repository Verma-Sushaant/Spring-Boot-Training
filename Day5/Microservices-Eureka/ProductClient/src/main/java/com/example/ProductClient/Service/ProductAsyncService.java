package com.example.ProductClient.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductAsyncService {
    @Autowired
    private RestTemplate restTemplate;

    @Async
    public void fetchProduct() {
        String response = restTemplate.getForObject("http://localhost:9000/product", String.class);
        System.out.println("Product received "+response);
    }
}