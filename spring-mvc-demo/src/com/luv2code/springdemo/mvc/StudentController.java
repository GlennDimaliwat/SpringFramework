package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	/*
	 * Notes for using #{} instead of ${}
	 * #{...} is for Spring Expression Language. It is used during configuration of Spring apps / components in .java files
	 * ${...} can be used during configuration of Spring apps / components in .xml files and .java files
  	 * ${...} can be used when rendering JSP page content in .jsp pages
	 */
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//Create a new Student object
		Student theStudent = new Student();
		
		//Add student object to the model
		theModel.addAttribute("student", theStudent);
		
		//Add country options to the model
		theModel.addAttribute("theCountryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// Log the input data
		System.out.println("theStudent: " + theStudent.getFirstName()
							+ " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}
