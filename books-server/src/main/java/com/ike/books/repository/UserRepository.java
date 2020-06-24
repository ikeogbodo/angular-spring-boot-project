package com.ike.books.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ike.books.entity.User;

public interface UserRepository<T extends User> extends CrudRepository<T, Long>{
    Optional<T> findByName(String name);

}
