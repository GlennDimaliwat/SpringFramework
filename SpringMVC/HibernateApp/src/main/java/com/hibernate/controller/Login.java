package com.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.dao.LoginDAO;

@Controller
public class Login {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("loginUser") String strUsername,
				   @RequestParam("loginPassword") String strPassword) {
		
		LoginDAO loginDAO = new LoginDAO();
		ModelAndView loginMV = new ModelAndView("login");
		if(loginDAO.isLoginCorrect(strUsername,strPassword)) {
			loginMV.addObject("result","Hello "+strUsername+"! You have logged in successfully!");
		}
		else {
			loginMV.addObject("result","Invalid username/password!");
		}
		return loginMV;
	}
}
