package com.example.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CartService.Consumer.PaymentStatusConsumer;

@RestController
public class CartRestController {
    
    @Autowired
    private PaymentStatusConsumer paymentStatusConsumer;
    @GetMapping("/cart/get-data")
    public String getCartData() {
        return "Returning Data from Cart Service";
    }

    @GetMapping("/cart/product-status")
    public String getProductStatus() {
        if(paymentStatusConsumer.getPaymentStatus().equals("Successfull")) {
            return "Product added successfully";
        }
        return "Payment failed";
    }
}