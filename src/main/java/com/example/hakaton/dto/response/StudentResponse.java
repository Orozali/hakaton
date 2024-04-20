package com.example.hakaton.dto.response;

import lombok.Builder;

@Builder
public record StudentResponse(
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
         String diploma
) {
}
