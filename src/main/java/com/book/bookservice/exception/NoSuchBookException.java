package com.book.bookservice.exception;

public class NoSuchBookException extends RuntimeException {

    private static final long serialVersionUID = 2270103263480008964L;
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
