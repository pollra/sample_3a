package com.example.sample_3a.api.exception;

/**
 * @since       2020.03.28
 * @author      pollra
 * @description TodoNotFoundException
 **********************************************************************************************************************/
public class TodoNotFoundException extends Exception {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
