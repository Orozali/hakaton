package com.example.hakaton.api;

import com.example.hakaton.config.jwt.JwtService;
import com.example.hakaton.dto.request.AuthenticateRequest;
import com.example.hakaton.dto.request.RegisterRequest;
import com.example.hakaton.dto.response.AuthenticationResponse;
import com.example.hakaton.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
//@Tag(name = "Authentication API")
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class AuthenticationApi {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public AuthenticationResponse signUp(@RequestBody @Valid RegisterRequest request){
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public AuthenticationResponse signIn(@RequestBody @Valid AuthenticateRequest request){
        return authenticationService.signIn(request);
    }

//    @PostMapping("/forget-password")
//    public SimpleResponse forgetPassword(@RequestBody @Valid ForgetPasswordRequest request){
//        return authenticationService.sendEmail(request);
//    }

//    @PostMapping("/confirm")
//    public SimpleResponse resetPassword(@RequestParam String token){
//        return authenticationService.confirm(token);
//    }
//
//    @PostMapping("/reset-password")
//    public AuthenticationResponse resetPassword(@RequestParam String email, @RequestBody @Valid ResetPasswordRequest request){
//        return authenticationService.resetPassword(request.newPassword(), email);
//    }

}
