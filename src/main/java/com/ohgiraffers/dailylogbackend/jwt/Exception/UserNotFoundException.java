package com.ohgiraffers.dailylogbackend.jwt.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
