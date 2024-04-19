package com.example.hakaton.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterRequest(
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Surname is required") String surName,
        @NotBlank(message = "Telephone number is required")
        @Pattern(regexp = "\\d{10}", message = "Telephone number must be 10 digits") String telNumber,
        @NotBlank(message = "University is required") String university,
        @NotBlank(message = "Faculty is required") String faculty,
        @NotBlank(message = "Profession is required") String profession,
        @NotNull(message = "Date from is required") int dateFrom,
        @NotNull(message = "Date to is required") int dateTo,
        @NotBlank(message = "Address is required") String address
){
}