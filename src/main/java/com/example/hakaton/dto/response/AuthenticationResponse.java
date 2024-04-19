package com.example.hakaton.dto.response;

import com.example.hakaton.entity.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticationResponse(
        UserResponse user,
        Role roles,
        String accessToken
) {
}
