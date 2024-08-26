package com.example.registerUser.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "UserName is required")
	@Size(min=3,max=25,message="UserName must be between 3 to 25 characters")
	private String userName;
	@NotBlank(message = "Password is required")
	@Size(min=8,message="Password must contain Special characters and numbers")
	private  String password;
	@NotBlank(message = "email is required")
	@Email(message="Email should be valid")
	private String email;
	@Past(message="Date of birth must be in the past")
	private LocalDate dateOfBirth;
	
	private boolean enabled=false;
	
}
