package com.book.bookservice.model;

import jakarta.persistence.*;



@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "BOOK_NAME")
    private String name;
    @Column(name = "BOOK_QUANTITY")
    private int quantity;
    @Column(name = "STATUS")
    private String status;
}
