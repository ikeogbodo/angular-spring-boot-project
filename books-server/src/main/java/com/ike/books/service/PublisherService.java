package com.ike.books.service;

import java.util.List;

import com.ike.books.entity.Publisher;

public interface PublisherService {
    
    Publisher createPublisher(Publisher publisher);
    Publisher deletePublisher(int id);
    List<Publisher> findAllPublishers();
    Publisher findPublisherById(int id);
    Publisher updatePublisher(Publisher publisher);
}
