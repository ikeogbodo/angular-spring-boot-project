package com.ike.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.ike.books.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    void delete(Author author);
    List<Author> findAll();
    Author findByauthorid(int id);
    Author save(Author author);
}
