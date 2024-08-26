package com.example.registerUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerUser.emailService.EmailService;
import com.example.registerUser.entity.User;
import com.example.registerUser.userService.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/register")
	public String register(@Valid @RequestBody User user) {
		
		try {
			User registeredUser=userService.registerUser(user);
			
			String token=generateConfirmationToken();
			String confirmationLink="https://localhost:8080/api/confirm?Token="+token;
			
			userService.saveConfirmationToken(registeredUser,token);
			
			emailService.sendConfirmationMail(registeredUser.getEmail(),confirmationLink);
			
			return "User registered Sucessfully. Please confirm your email to confirm your registration";
		}
		catch(IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private String generateConfirmationToken() {

		return java.util.UUID.randomUUID().toString();
	}
}
