package com.ike.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ike.books.Exception.ResourceNotFoundException;
import com.ike.books.entity.Publisher;
import com.ike.books.service.PublisherService;

@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/publishers"})
public class PublishersController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public Publisher create(@RequestBody Publisher publisher){
        return publisherService.createPublisher(publisher);
    }

    @GetMapping(path = {"/{id}"})
    public Publisher findPublisherById(@PathVariable("id") int id){
    	Publisher publisher = publisherService.findPublisherById(id);
    	if (publisher == null) {
    		throw new ResourceNotFoundException("Publisher not found with id " + id);
    	}
    	
    	return publisher;
    }

    @PutMapping
    public Publisher updatePublisher(@RequestBody Publisher publisher){
        return publisherService.updatePublisher(publisher);
    }

    @DeleteMapping(path ={"/{id}"})
    public Publisher deletePublisher(@PathVariable("id") int id) {
        return publisherService.deletePublisher(id);
    }

    @GetMapping    
    public List<Publisher> findAllPublishers(){
       return publisherService.findAllPublishers();
    }
}
