package com.ike.books.service;

import java.util.List;

import com.ike.books.entity.Book;

public interface BookService {

    Book create(Book user);
    Book delete(int id);
    List<Book> findAll();
    Book findById(int id);
    Book update(Book user);
}
