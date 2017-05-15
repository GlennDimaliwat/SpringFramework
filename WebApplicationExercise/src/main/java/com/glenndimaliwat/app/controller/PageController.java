package com.glenndimaliwat.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glenndimaliwat.app.domain.Message;
import com.glenndimaliwat.app.service.PageService;

@Controller
public class PageController {

	@Autowired
	PageService pageService;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("This should override the static folder.");
		return "index";
	}
	
	@RequestMapping("/message")
	public String displayMessageWithoutThymeleaf() {
		
		//Do not fill the message object
		//Cause an error
		
		return "views/message";
	}
	
	@RequestMapping("/messageTL")
	public String displayMessageInThymeleaf(Model theModel) {
		
		//Fill the message object
		Message theMessage = pageService.createMessage();
		
		System.out.println(theMessage.toString());
		
		theModel.addAttribute("message", theMessage);
		
		return "views/message";
	}
	
	@RequestMapping("/causeAnException")
	public String causeAnException(Model theModel) throws Exception {
		throw new Exception("A custom exception has occured!");
	}
	/*
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception theException, Model model){
		model.addAttribute("exception", theException.getMessage() );
		return "views/exception";
	}
	*/
}
