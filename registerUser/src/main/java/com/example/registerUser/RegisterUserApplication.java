package com.example.registerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.registerUser.emailService.EmailService;

@SpringBootApplication
public class RegisterUserApplication {


	public static void main(String[] args) {
		SpringApplication.run(RegisterUserApplication.class, args);
	}

}
