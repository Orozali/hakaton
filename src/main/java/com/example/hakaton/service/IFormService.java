package com.example.hakaton.service;

import com.example.hakaton.dto.request.FormRequest;

import java.util.List;

public interface IFormService {
    void createForm(List<FormRequest> formRequests);
}
