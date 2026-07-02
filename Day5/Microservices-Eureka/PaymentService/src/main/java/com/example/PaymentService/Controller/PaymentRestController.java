package com.example.PaymentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaymentService.Consumer.BankRestConsumer;

@RestController
public class PaymentRestController {
    
    @Autowired
    private BankRestConsumer bankRestConsumer;
    @GetMapping("/payment-status")
    public String getPaymentData() {
        if(bankRestConsumer.getBankStatus()) {
            return "Successfull";
        }
        else {
            return "Failed";
        }
    }
}