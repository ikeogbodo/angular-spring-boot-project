package com.ike.books.service;

import java.util.List;

import com.ike.books.entity.User;

public interface UserService {
	User creatUser(User user);
    List<User> findAllUsers();
    User updateUser(User user);
}
