package com.ike.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ike.books.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    void delete(Book book);
    List<Book> findAll();
    Book findBybookid(int id);
    Book save(Book book);
}
