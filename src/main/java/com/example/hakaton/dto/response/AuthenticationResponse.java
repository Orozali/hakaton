package com.example.hakaton.dto.response;

import com.example.hakaton.entity.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String email,
        Role roles,
        String accessToken,
        String refreshToken
) {
}
