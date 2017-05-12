package com.glenndimaliwat.loginpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPage {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("loginUser") String strUsername,
				   @RequestParam("loginPassword") String strPassword) {
		
		final String correctUser = "glenndimaliwat";
		final String correctPassword = "pass1234";
		
		//model.addAttribute("message", "Hello Spring MVC Framework!");
		System.out.println(strUsername);
		System.out.println(strPassword);
		ModelAndView loginMV = new ModelAndView("login");
		if(strUsername.equalsIgnoreCase(correctUser) && strPassword.equalsIgnoreCase(correctPassword)) {
			loginMV.addObject("result","Hello "+correctUser+"! You have logged in successfully!");
		}
		else {
			loginMV.addObject("result","Invalid username/password!");
		}
		return loginMV;
	}
}
