package com.example.hakaton.exception.exceptions;

public class BadCredentialException extends RuntimeException{
    public BadCredentialException(String msg){
        super(msg);
    }
}
