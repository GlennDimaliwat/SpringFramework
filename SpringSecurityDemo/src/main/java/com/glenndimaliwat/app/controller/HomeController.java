package com.glenndimaliwat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glenndimaliwat.app.service.UserService;

@Controller
public class HomeController {
	
	//@Autowired
	//UserService userService;
	
	@RequestMapping("/")
	public String home(){
		
		// Test e-mail in JPA
		//System.out.println(userService);
		
		return "index";
	}
}
