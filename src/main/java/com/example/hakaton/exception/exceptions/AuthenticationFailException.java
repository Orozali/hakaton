package com.example.hakaton.exception.exceptions;

public class AuthenticationFailException extends RuntimeException{
    public AuthenticationFailException(String msg){
        super(msg);
    }
}
