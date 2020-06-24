package com.ike.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ike.books.entity.Publisher;
import com.ike.books.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {
    
    private PublisherRepository publisherRepository;

    @Autowired
    public void setPublisherRepository(PublisherRepository publisher_Repository) {
    	publisherRepository = publisher_Repository;
    }
    
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher deletePublisher(int id) {
    	Publisher publisher = findPublisherById(id);
        if(publisher != null){
        	publisherRepository.delete(publisher);
        }
        return publisher;
    }

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(int id) {
        return publisherRepository.findBypublisherid(id);
    }

    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

}
