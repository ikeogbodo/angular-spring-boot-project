package com.ike.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ike.books.Exception.ResourceNotFoundException;
import com.ike.books.entity.Author;
import com.ike.books.entity.Book;
import com.ike.books.service.BookService;

@CrossOrigin()
@RestController
@RequestMapping({"/authors"})
public class AuthorsController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Author create(@RequestBody Author author){
        return bookService.createAuthor(author);
    }

    @GetMapping(path = {"/{id}"})
    public Author findOne(@PathVariable("id") int id){
        Author author = bookService.findAuthorById(id);
    	if (author == null) {
    		throw new ResourceNotFoundException("Author not found with id " + id);
    	}
    	
    	return author;
    }

    @PutMapping
    public Author update(@RequestBody Author author){
        return bookService.updateAuthor(author);
    }

    @DeleteMapping(path ={"/{id}"})
    public Author delete(@PathVariable("id") int id) {
        return bookService.deleteAuthor(id);
    }

    @GetMapping    
    public List<Author> findAllAuthors(){
        return bookService.findAllAuthors();
    }
}
