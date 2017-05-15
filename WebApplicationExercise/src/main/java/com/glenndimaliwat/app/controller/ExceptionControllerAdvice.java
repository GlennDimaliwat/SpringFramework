package com.glenndimaliwat.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String exception(Exception exception, Model model){
		System.out.println("ExceptionControllerAdvice triggered!");
		model.addAttribute("exception", exception);
		return "views/exception";
	}
	
}