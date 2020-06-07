package com.ike.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ike.books.entity.Book;
import com.ike.books.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    public Book create(Book user) {
        return repository.save(user);
    }

    public Book delete(int id) {
        Book user = findById(id);
        if(user != null){
            repository.delete(user);
        }
        return user;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(int id) {
        return repository.findOne(id);
    }

    public Book update(Book user) {
        return repository.save(user);
    }
}
