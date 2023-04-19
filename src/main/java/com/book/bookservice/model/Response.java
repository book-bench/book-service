package com.book.bookservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Response {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Book> books;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors;

    public List<Book> getBooks() {
        return books;
    }
    public static Response createResponseWithBooks(List<Book> books) {
        Response response = new Response();
        response.setBooks(books);
        return response;
    }

    public static Response createResponseWithErrors(List<String> errors) {
        Response response = new Response();
        response.setErrors(errors);
        return response;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
