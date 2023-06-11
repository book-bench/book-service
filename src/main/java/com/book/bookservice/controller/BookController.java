package com.book.bookservice.controller;


import com.book.bookservice.model.Book;
import com.book.bookservice.model.Response;
import com.book.bookservice.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {

    @Value("${log-messages.request-log}")
    private transient String requestLogMessage;

    @Value("${log-messages.response-log}")
    private transient String responseLogMessage;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private transient BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    HttpMethod hello = HttpMethod.valueOf("Hello");



    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getBooks(HttpServletRequest request) {
        logger.info(requestLogMessage,request.getMethod(), request.getRequestURI());
        List<Book> books = bookService.getAllBooks();
        logger.info(responseLogMessage, books);
        return Response.createResponseWithAtLeastOneBook(books);
    }

    @GetMapping("/{id}")
    public Response getBookById(@PathVariable Integer id, HttpServletRequest request) {
        logger.info(requestLogMessage,request.getMethod(), request.getRequestURI());
        List<Book> books = new ArrayList<>();
        books.add(bookService.getBookById(id));
        logger.info(responseLogMessage, books);
        return Response.createResponseWithAtLeastOneBook(books);
    }

    @PatchMapping("/{id}")
    public  Response updateBookQuantity(@PathVariable Integer id,  @RequestParam @Min(0) Integer quantity, HttpServletRequest request) {
        logger.info(requestLogMessage,request.getMethod(), request.getRequestURI(), request.getQueryString());
        Book book = bookService.updateBookQuantity(id, quantity);
        logger.info(responseLogMessage, book);


        return Response.createResponseWithAtLeastOneBook(book);
    }
}
