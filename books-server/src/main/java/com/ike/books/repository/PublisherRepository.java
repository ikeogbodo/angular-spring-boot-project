package com.ike.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.ike.books.entity.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    void delete(Publisher publisher);
    List<Publisher> findAll();
    Publisher findBypublisherid(int id);
    Publisher save(Publisher publisher);
}
