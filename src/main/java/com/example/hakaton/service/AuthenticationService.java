package com.example.hakaton.service;

import com.example.hakaton.dto.request.AuthenticateRequest;
import com.example.hakaton.dto.request.RegisterRequest;
import com.example.hakaton.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse signUp(RegisterRequest request);

    AuthenticationResponse signIn(AuthenticateRequest request);
}
