package com.ike.books.repository;

import org.springframework.data.repository.Repository;

import com.ike.books.entity.Book;

import java.util.List;

public interface BookRepository extends Repository<Book, Integer> {

    void delete(Book user);
    List<Book> findAll();
    Book findOne(int id);
    Book save(Book user);
}
