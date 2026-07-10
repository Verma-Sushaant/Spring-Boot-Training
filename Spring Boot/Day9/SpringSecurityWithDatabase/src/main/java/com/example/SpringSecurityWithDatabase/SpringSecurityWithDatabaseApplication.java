package com.example.SpringSecurityWithDatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.SpringSecurityWithDatabase.Entity.User;
import com.example.SpringSecurityWithDatabase.Repository.UserRepository;

@SpringBootApplication
public class SpringSecurityWithDatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWithDatabaseApplication.class, args);
    }

    @Bean
    @SuppressWarnings("unused")
    CommandLineRunner init(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            repo.save(new User("SVerma", encoder.encode("SV50$"), "USER"));
            repo.save(new User("RKumar", encoder.encode("@Rohan220"), "ADMIN"));
        };
    }
}
