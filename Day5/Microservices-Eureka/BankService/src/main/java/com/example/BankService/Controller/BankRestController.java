package com.example.BankService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

    @GetMapping("/bank-status")
    public String getPayment() {
        return "Online";
    }
}