package com.example.SinglePageNavigation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping("/student")
    public String student(Model model) {
        model.addAttribute("title","Student details");
        model.addAttribute("name","Sushaant Verma");
        model.addAttribute("course","B.Tech");
        model.addAttribute("semester","6th semester");
        model.addAttribute("college","LPU");
        return "dashboard";
    }
}
