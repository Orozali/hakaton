package com.example.hakaton.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record UserResponse(
         Long id,
         String name,
         String surName,
         String telNumber,
         String university,
         String faculty,
         String profession,
         int dateFrom,
         int dateTo,
         String email,
         String address,
         String image,
         String diplom
) {
}
