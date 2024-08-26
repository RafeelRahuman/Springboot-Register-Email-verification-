package com.example.registerUser.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendConfirmationMail(String to,String confirmationlink) {
		
		SimpleMailMessage message1=new SimpleMailMessage();
		
		message1.setTo(to);
		message1.setSubject("Confirm your registration");
		message1.setText("Please confirm your registration by clicking the following link: " + confirmationlink);
		message1.setFrom("mmohamedrafil@outlook.com");
		
		mailSender.send(message1);
		
	}
}
