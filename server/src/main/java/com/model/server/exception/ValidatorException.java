package com.model.server.exception;

public class ValidatorException extends RuntimeException{

    public ValidatorException(String message) {
        super(message);
    }
}