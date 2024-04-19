package com.example.hakaton.service;

import com.example.hakaton.dto.request.AuthenticateRequest;
import com.example.hakaton.dto.request.RegisterRequest;
import com.example.hakaton.dto.response.AuthenticationResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse signUp(RegisterRequest request) throws IOException;

    AuthenticationResponse signIn(AuthenticateRequest request);
}
