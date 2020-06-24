package com.ike.books.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ike.books.entity.User;
import com.ike.books.model.AuthenticationRequest;
import com.ike.books.model.AuthenticationResponse;
import com.ike.books.service.JwtUserDetailsService;
import com.ike.books.service.UserServiceImpl;
import com.ike.books.util.JwtUtil;

@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/users"})
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired 
	JwtUtil jwtTokenUtil;

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticatinRequest) throws Exception {
	try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticatinRequest.getUsername(), authenticatinRequest.getPassword()));
	}catch (BadCredentialsException e) {
		throw new Exception("Incorrect username or password", e);
	}
	
	final UserDetails userDetails = userDetailsService
			.loadUserByUsername(authenticatinRequest.getUsername());
	
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

	@PostMapping (path = "/createuser")
	public User createUser(@RequestBody User user) {
		return userService.creatUser(user);
	}
	
	@PutMapping (path = "/updateuser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}	
}
