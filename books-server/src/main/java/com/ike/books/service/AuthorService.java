package com.ike.books.service;

import java.util.List;

import com.ike.books.entity.Author;
import com.ike.books.entity.Book;
import com.ike.books.entity.Publisher;

public interface AuthorService {
    
    Author createAuthor(Author author);
    Author deleteAuthor(int id);
    List<Author> findAllAuthors();
    Author findAuthorById(int id);
    Author updateAuthor(Author author);
    
}
