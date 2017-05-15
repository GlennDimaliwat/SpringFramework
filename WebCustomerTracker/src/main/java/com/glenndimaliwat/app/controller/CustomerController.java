package com.glenndimaliwat.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glenndimaliwat.app.entity.Customer;
import com.glenndimaliwat.app.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
		
	// Inject customer service
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get all customers from service (Ordered by Last Name Asc)
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Transfer customers to Model
		theModel.addAttribute("customers", theCustomers);
		
		// Go to the Customer List
		return "view/list-customers";
	
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// Create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		// Add customer to the model
		theModel.addAttribute("customer", theCustomer);
		
		// Go to the Customer Form
		return "view/customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,
								BindingResult theBindingResult) {
		
		// Debug
		System.out.println(theCustomer.toString());
		
		if(theBindingResult.hasErrors()) {
			// Stay in Customer Form
			return "view/customer-form";
		}
		else {
			// Save the customer using our service
			customerService.saveCustomer(theCustomer);
			
			// Go back to the Customer List
			return "redirect:/list";
		}
		
	}
	
	@PostMapping("/showFormUpdate")
	public String showFormUpdated(@RequestParam("customerId") int theId, Model theModel) {
		
		// Get customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// Debug
		System.out.println(theCustomer.toString());
		
		// Add customer to the model
		theModel.addAttribute("customer", theCustomer);
		
		// Go to the Customer Form
		return "view/customer-form";
	}
	
	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// Delete the customer
		customerService.deleteCustomer(theId);
		
		// Go back to the Customer List
		return "redirect:/list";
				
	}
}
