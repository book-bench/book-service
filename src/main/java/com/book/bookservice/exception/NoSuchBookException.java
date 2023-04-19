package com.book.bookservice.exception;

public class NoSuchBookException extends RuntimeException {
    private int bookId;
    public NoSuchBookException(int id) {
        super();
        this.bookId = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
