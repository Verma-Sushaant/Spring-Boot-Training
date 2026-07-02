package com.example.Task.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class UserLogin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotBlank(message="Name cannot be null")
    @Column(nullable=false)
    private String name;

    @NotBlank(message="Username cannot be empty.")
    @Column(nullable=false)
    private String username;

    @NotBlank(message="Password is required.")
    @Column(nullable=false) 
    private String password;
}
