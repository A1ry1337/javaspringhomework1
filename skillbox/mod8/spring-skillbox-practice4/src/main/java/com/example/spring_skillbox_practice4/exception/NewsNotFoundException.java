package com.example.spring_skillbox_practice4.exception;

public class NewsNotFoundException extends RuntimeException {

    public NewsNotFoundException(String message) {
        super(message);
    }
}