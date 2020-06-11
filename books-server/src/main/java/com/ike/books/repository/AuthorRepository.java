package com.ike.books.repository;

import org.springframework.data.repository.Repository;

import com.ike.books.entity.Author;

import java.util.List;

public interface AuthorRepository extends Repository<Author, Integer> {

    void delete(Author author);
    List<Author> findAll();
    Author findOne(int id);
    Author save(Author author);
}
