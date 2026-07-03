package com.example.Aspectdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Aspectdemo.service.MyService;

@SpringBootApplication
public class AspectDemoApplication implements CommandLineRunner {
	@Autowired
	private MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(AspectDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		myService.displayMessage();
	}

}
