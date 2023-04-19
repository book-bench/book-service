package com.book.bookservice.exception;

public class NoSuchBookException extends RuntimeException {
    public NoSuchBookException(String message) {
        super(message);
    }
}
