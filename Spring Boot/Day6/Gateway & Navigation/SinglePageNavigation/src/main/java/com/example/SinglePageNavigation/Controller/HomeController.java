package com.example.SinglePageNavigation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("message", "Welcome to the school Portal Home Page");
        return "dashboard";
    }
}