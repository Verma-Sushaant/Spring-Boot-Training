package com.example.Task.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegDto {
    @NotBlank(message="Name cannot be null")
    private String name;

    @NotBlank(message="Username cannot be empty.")
    private String username;

    @NotBlank(message="Password is required.") 
    private String password;

    @NotBlank(message="Confirm Password should match the password.")
    private String confirmPassword;

    @NotBlank(message="Secret Key is required")
    private String secretKey;
}
