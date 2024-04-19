package com.example.hakaton.service;

import com.example.hakaton.dto.request.ApplicationRequest;
import com.example.hakaton.dto.response.ApplicationResponse;
import com.example.hakaton.dto.response.SimpleResponse;

import java.util.List;

public interface ApplicationService {
    SimpleResponse approve(ApplicationRequest request);

    List<ApplicationResponse> getAllApplication();
}
