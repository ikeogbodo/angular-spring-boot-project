package com.ike.books.service;

import java.util.List;

import com.ike.books.entity.Author;
import com.ike.books.entity.Book;
import com.ike.books.entity.Publisher;

public interface BookService {

    Book create(Book user);
    Book delete(int id);
    List<Book> findAll();
    Book findById(int id);
    Book update(Book user);
    
    Author createAuthor(Author author);
    Author deleteAuthor(int id);
    List<Author> findAllAuthors();
    Author findAuthorById(int id);
    Author updateAuthor(Author author);
    
    Publisher createPublisher(Publisher publisher);
    Publisher deletePublisher(int id);
    List<Publisher> findAllPublishers();
    Publisher findPublisherById(int id);
    Publisher updatePublisher(Publisher publisher);
}
