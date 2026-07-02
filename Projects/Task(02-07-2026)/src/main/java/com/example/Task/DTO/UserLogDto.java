package com.example.Task.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLogDto {
    @NotBlank(message="Username cannot be empty.")
    private String username;
    @NotBlank(message="Password is required")
    private String password;
}
