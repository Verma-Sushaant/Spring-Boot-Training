package com.example.Task.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PasswordChangeDto {
    @NotBlank(message="Password is required.")
    private String newPassword;

    @NotBlank(message="Username is must for password change.")
    private String username;

    @NotBlank(message="Secret Key is required.")
    private String secretKey;
}
