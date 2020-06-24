package com.ike.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ike.books.entity.Book;
import com.ike.books.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository book_Repository) {
    	bookRepository = book_Repository;
    }

    public Book create(Book book) {
   	 	return bookRepository.save(book);
    }

    public Book delete(int id) { 
    	System.out.println("In Delete Service");
        Book book = findById(id);
        if(book != null){
        	bookRepository.delete(book);
        }
        return book;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
    	return bookRepository.findOne(id);

    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }
}
