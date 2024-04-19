package com.example.hakaton.service;

import com.example.hakaton.dto.request.ApplicationRequest;
import com.example.hakaton.dto.response.SimpleResponse;

public interface ApplicationService {
    SimpleResponse approve(ApplicationRequest request);
}
