package com.example.jpa.board.exception;

public class BarodNotFoundException extends RuntimeException {
    public BarodNotFoundException(String message) {
        super(message);
    }
}
