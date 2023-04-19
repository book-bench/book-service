package com.book.bookservice.repository;

import com.book.bookservice.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Integer id);
}
