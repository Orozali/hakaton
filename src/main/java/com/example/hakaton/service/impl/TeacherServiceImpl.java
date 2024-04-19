package com.example.hakaton.service.impl;

import com.example.hakaton.config.jwt.JwtService;
import com.example.hakaton.dto.request.ApplicationRequest;
import com.example.hakaton.dto.response.SimpleResponse;
import com.example.hakaton.entity.User;
import com.example.hakaton.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final JwtService jwtService;
    @Override
    public SimpleResponse approve(ApplicationRequest request) {
        User user = jwtService.getAuthenticate();

        return null;
    }
}
