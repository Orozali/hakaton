package com.example.hakaton.dto.response;

import lombok.Builder;

@Builder
public record ApplicationResponse (
        Long id,
        String name,
        String surName,
        String tellNumber,
        String email
){
}
