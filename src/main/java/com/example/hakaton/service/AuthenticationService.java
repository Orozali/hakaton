package com.example.hakaton.service;

import com.example.hakaton.dto.request.AuthenticateRequest;
import com.example.hakaton.dto.request.RegisterRequest;
import com.example.hakaton.dto.response.AuthenticationResponse;
import com.example.hakaton.dto.response.AuthorizationResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse signUp(RegisterRequest request) throws IOException;

    AuthorizationResponse signIn(AuthenticateRequest request) throws IOException;
}
