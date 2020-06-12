package com.ike.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ike.books.Exception.ResourceNotFoundException;
import com.ike.books.entity.Author;
import com.ike.books.entity.Book;
import com.ike.books.entity.Publisher;
import com.ike.books.service.BookService;

@CrossOrigin()
@RestController
@RequestMapping({"/books"})
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }

    @GetMapping(path = {"/{id}"})
    public Book findOne(@PathVariable("id") int id){
    	Book book = bookService.findById(id);
    	if (book == null) {
    		throw new ResourceNotFoundException("Author not found with id " + id);
    	}
    	return book;
    }

    @PutMapping
    public Book update(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping(path ={"/{id}"})
    public Book delete(@PathVariable("id") int id) {
        return bookService.delete(id);
    }

    @GetMapping    
    public List<Book> findAll(){
    	System.out.println("in Findall");
        return bookService.findAll();
    }
}
