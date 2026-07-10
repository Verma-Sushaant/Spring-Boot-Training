package com.example.Aspectdemo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void displayMessage() {
        System.out.println("Inside Business Method");
    }
}
