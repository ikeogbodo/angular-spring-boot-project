package com.ike.books.repository;

import org.springframework.data.repository.Repository;

import com.ike.books.entity.Publisher;

import java.util.List;

public interface PublisherRepository extends Repository<Publisher, Integer> {

    void delete(Publisher publisher);
    List<Publisher> findAll();
    Publisher findOne(int id);
    Publisher save(Publisher publisher);
}
