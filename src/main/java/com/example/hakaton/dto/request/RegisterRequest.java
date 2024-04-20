package com.example.hakaton.dto.request;

import com.example.hakaton.validation.EmailValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.multipart.MultipartFile;

public record RegisterRequest(
        String departmentId,
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Surname is required") String surName,
        @NotBlank(message = "Telephone number is required")
        String telNumber,
        @NotBlank(message = "This field should't be empty")
        @EmailValid(message = "Пользователь с таким адресом электронной почты уже существует!")
        String email,
        @NotBlank(message = "University is required") String university,
        @NotBlank(message = "Faculty is required") String faculty,
        @NotBlank(message = "Profession is required") String profession,
        @NotNull(message = "Date from is required") int dateFrom,
        @NotNull(message = "Date to is required") int dateTo,
        @NotBlank(message = "Address is required") String address,
        MultipartFile image,
        MultipartFile diploma
){
}