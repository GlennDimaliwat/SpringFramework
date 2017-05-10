package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//Need a controller method to show initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//New controller to read form data
	//Add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//Read request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		//Convert data to all caps
		theName = theName.toUpperCase();
		
		//Create the message
		String result = "Yo! " + theName;
		
		//Add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, Model model) {
		
		//Convert data to all caps
		theName = theName.toUpperCase();
		
		//Create the message
		String result = "Hey My Friend from v3! " + theName;
		
		//Add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	

	
}
