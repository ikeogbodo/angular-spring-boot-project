package com.ike.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ike.books.Exception.ResourceNotFoundException;
import com.ike.books.entity.Author;
import com.ike.books.service.AuthorService;

@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/authors"})
public class AuthorsController {

    @Autowired
    private AuthorService athorService;

    @PostMapping
    public Author create(@RequestBody Author author){
        return athorService.createAuthor(author);
    }

    @GetMapping(path = {"/{id}"})
    public Author findOne(@PathVariable("id") int id){
        Author author = athorService.findAuthorById(id);
    	if (author == null) {
    		throw new ResourceNotFoundException("Book not found with id " + id);
    	}
    	
    	return author;
    }

    @PutMapping
    public Author update(@RequestBody Author author){
        return athorService.updateAuthor(author);
    }

    @DeleteMapping(path ={"/{id}"})
    public Author delete(@PathVariable("id") int id) {
        return athorService.deleteAuthor(id);
    }

    @GetMapping    
    public List<Author> findAllAuthors(){
        return athorService.findAllAuthors();
    }
}
