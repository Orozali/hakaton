package com.example.hakaton.service.impl;

import com.example.hakaton.dto.request.AuthenticateRequest;
import com.example.hakaton.dto.request.RegisterRequest;
import com.example.hakaton.dto.response.AuthenticationResponse;
import com.example.hakaton.entity.Student;
import com.example.hakaton.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public AuthenticationResponse signUp(RegisterRequest request) {
        Student student = Student.builder()
                .name(request.name())
                .surName(request.surName())
                .address(request.address())
                .telNumber(request.telNumber())
                .university(request.university())
                .faculty(request.faculty())
                .profession(request.profession())
                .dateFrom(request.dateFrom())
                .dateTo(request.dateTo())
                .build();

        return null;
    }

    @Override
    public AuthenticationResponse signIn(AuthenticateRequest request) {
        return null;
    }
}
