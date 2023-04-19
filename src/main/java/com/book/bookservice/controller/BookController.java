package com.book.bookservice.controller;


import com.book.bookservice.model.Book;
import com.book.bookservice.model.Response;
import com.book.bookservice.repository.BookRepository;
import com.book.bookservice.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public Response getBooks() {
        List<Book> books = bookService.getAllBooks();
        return Response.createResponseWithBooks(books);
    }

    @GetMapping("/{id}")
    public Response getBookById(@PathVariable Integer id) {
        List<Book> books = new ArrayList<>();
        books.add(bookService.getBookById(id));
        return Response.createResponseWithBooks(books);
    }

    @PutMapping("/{id}")
    public  Response updateBookQuantity(@PathVariable Integer id, @RequestParam Integer quantity) {
        return null;
    }
}
