package com.example.registerUser.confirmationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerUser.entity.User;
import com.example.registerUser.entityConfirmationToken.ConfirmationToken;
import com.example.registerUser.userService.UserService;

@RestController
@RequestMapping("/api")
public class ConfirmationController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/confirm")
	public String confirmationMail(@RequestParam("Token") String token) {
		
		ConfirmationToken confirmationToken=userService.findByToken(token);
		
		if(confirmationToken!=null) {
		    User user=confirmationToken.getUser();
		    
		    user.setEnabled(true);
		    userService.registerUser(user);
		    
		    return "Email confirmed.Your account is now active"; 
		}
		
		else {
			return "Invalid confirmation Link";
		}
	}
	
}
