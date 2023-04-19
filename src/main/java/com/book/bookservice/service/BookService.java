package com.book.bookservice.service;

import com.book.bookservice.controller.ExceptionController;
import com.book.bookservice.exception.NoSuchBookException;
import com.book.bookservice.model.Book;
import com.book.bookservice.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Value("${log-messages.no-such-book}")
    private String noSuchBookLogMsg;

    @Value("${log-messages.updated-book}")
    private String updatedBookMsg;


    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book getBookById(Integer id) {

        return bookRepository.findById(id)
                            .orElseThrow(()-> {
                                logger.info(String.format(noSuchBookLogMsg, id));
                                return new NoSuchBookException(String.format(noSuchBookLogMsg, id));
                            });

    }

    public Book updateBookQuantity(Integer id, Integer quantity) {
        Book book = getBookById(id);
        book.setQuantity(quantity);
        bookRepository.save(book);
        logger.info(updatedBookMsg, book);
        return book;
    }
}
