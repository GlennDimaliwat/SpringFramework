package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Need to inject the customer service
	@Autowired
	CustomerService customerService;
	
	//@RequestMapping("/list")
	//@PostMapping("/list")
	@GetMapping("/list")	
	public String listCustomers(Model model) {
		
		// Get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add customers to the model
		model.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
	}
	
	//@RequestMapping("/showFormForAdd")
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//Create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		// Add customer to the model
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//Save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	//@GetMapping("/showFormUpdate")
	@PostMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int theId,
								 Model theModel) {
		// Get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// Set the customer as model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// Send over to our form
		return "customer-form";
	}
	
	//@GetMapping("/delete")
	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// Delete the customer
		customerService.deleteCustomer(theId);
		
		// Return the customer list
		return "redirect:/customer/list";
	}
}
