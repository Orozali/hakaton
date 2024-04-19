package com.example.hakaton.dto.request;

import com.example.hakaton.entity.enums.Status;

public record ApplicationRequest(
        Long applicationId,
        Status status
) {
}
