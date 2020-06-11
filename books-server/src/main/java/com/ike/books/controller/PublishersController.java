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
@RequestMapping({"/publishers"})
public class PublishersController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Publisher create(@RequestBody Publisher publisher){
        return bookService.createPublisher(publisher);
    }

    @GetMapping(path = {"/{id}"})
    public Publisher findPublisherById(@PathVariable("id") int id){
    	Publisher publisher = bookService.findPublisherById(id);
    	if (publisher == null) {
    		throw new ResourceNotFoundException("Publisher not found with id " + id);
    	}
    	
    	return publisher;
    }

    @PutMapping
    public Publisher updatePublisher(@RequestBody Publisher publisher){
        return bookService.updatePublisher(publisher);
    }

    @DeleteMapping(path ={"/{id}"})
    public Publisher deletePublisher(@PathVariable("id") int id) {
        return bookService.deletePublisher(id);
    }

    @GetMapping    
    public List<Publisher> findAllPublishers(){
        return bookService.findAllPublishers();
    }
}
