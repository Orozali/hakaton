package com.example.hakaton.dto.response;

import com.example.hakaton.entity.enums.Role;
import lombok.Builder;

@Builder
public record AuthorizationResponse(
        StudentResponse user,
        Role roles,
        String accessToken
) {
}
