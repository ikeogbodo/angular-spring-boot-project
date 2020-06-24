package com.ike.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ike.books.entity.User;
import com.ike.books.model.CustomUserDetails;
import com.ike.books.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository user_Repository) {
    	userRepository = user_Repository;
    }
	
	public User creatUser(User user) {
		return (User) userRepository.save(user);
	}
	
    @SuppressWarnings("unchecked")
	public User deleteUser(String username) {
    	Optional user = userRepository.findByName(username);
    	Optional<User> optionalUser = userRepository.findByName(username);    	

        optionalUser
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        
         userRepository.delete(optionalUser);
        
        return optionalUser
        .map(CustomUserDetails::new).get();
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User updateUser(User user) {
        return (User) userRepository.save(user);
    }



}
