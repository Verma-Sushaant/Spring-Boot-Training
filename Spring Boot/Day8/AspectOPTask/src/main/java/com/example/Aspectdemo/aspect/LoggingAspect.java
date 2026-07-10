package com.example.Aspectdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before(value="execution(* com.example.Aspectdemo.service.MyService.displayMessage(..))")
    public void beforeAdvice() {
        System.out.println("Preparing for interview ");
    }
    @After(value="execution(* com.example.Aspectdemo.service.MyService.displayMessage(..))")
    public void afterAdvice() {
        System.out.println("Interview Completed");
    }
}
