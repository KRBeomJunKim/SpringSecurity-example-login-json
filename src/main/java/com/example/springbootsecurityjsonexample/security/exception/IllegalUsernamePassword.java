package com.example.springbootsecurityjsonexample.security.exception;

public class IllegalUsernamePassword extends AuthenticationJsonException{
    public IllegalUsernamePassword(String message) {
        super(message);
    }
}
