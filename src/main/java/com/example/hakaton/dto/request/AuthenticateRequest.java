package com.example.hakaton.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AuthenticateRequest(
        @NotBlank(message = "This field should't be empty")
        @Pattern(regexp = "^\\d{4}\\.\\d{5}@manas\\.edu\\.kg$", message = "Email should be in this format 1234.12345@manas.edu.kg")
        String email,
        @NotBlank(message = "Password should't be empty")
        String password
) {
}
