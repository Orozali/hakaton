package com.example.hakaton.dto.response;

import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String email,
        String role
) {
}
