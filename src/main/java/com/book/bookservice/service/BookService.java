package com.book.bookservice.service;

import com.book.bookservice.exception.NoSuchBookException;
import com.book.bookservice.model.Book;
import com.book.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book getBookById(Integer id) {

        return bookRepository.findById(id)
                            .orElseThrow(()-> new NoSuchBookException(String.format("Book with id = %s  doesn't exist", id)));

    }
}
