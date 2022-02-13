package com.example.springbootsecurityjsonexample.security.exception;

public class AuthenticationJsonException extends RuntimeException {
    public AuthenticationJsonException(String message) {
        super(message);
    }
}
