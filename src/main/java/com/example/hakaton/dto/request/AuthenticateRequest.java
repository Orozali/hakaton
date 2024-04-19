package com.example.hakaton.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthenticateRequest(
        @NotBlank(message = "This field should't be empty")
        String email,
        @NotBlank(message = "Password should't be empty")
        String password
) {
}
