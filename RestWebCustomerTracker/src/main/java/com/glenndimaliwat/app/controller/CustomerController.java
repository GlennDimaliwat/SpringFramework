package com.glenndimaliwat.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glenndimaliwat.app.domain.Customer;
import com.glenndimaliwat.app.exception.CustomerNotFoundException;
import com.glenndimaliwat.app.service.CustomerCrudService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerCrudService customerCrudService;
	
	@RequestMapping( value="/", method = RequestMethod.GET )
	public Iterable<Customer> list() {
		return customerCrudService.list();
	}
	
	@RequestMapping( value="/", method = RequestMethod.POST )
	public Customer create( @RequestBody Customer theCustomer ) {
		return customerCrudService.create(theCustomer);
	}

	@RequestMapping( value="/{id}", method = RequestMethod.GET )
	public Customer read( @PathVariable(value="id") int id ) {
		
		// Read customer
		Customer theCustomer = customerCrudService.read(id);
		
		// Handle null customer
		if( theCustomer == null ) {
			throw new CustomerNotFoundException("Customer with id: " + id + " not found");
		}
		
		return customerCrudService.read(id);
	}
	
	@RequestMapping( value="/{id}", method = RequestMethod.PUT )
	public Customer update( @PathVariable(value="id") int id, @RequestBody Customer theCustomer ) {
		return customerCrudService.update(id, theCustomer);
	}
	
	@RequestMapping( value="/{id}", method = RequestMethod.DELETE )
	public void delete( @PathVariable(value="id") int id ) {
		customerCrudService.delete(id);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public void handleCustomerNotFound(CustomerNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError( HttpStatus.NOT_FOUND.value(), exception.getMessage() );
	}
	
	
}
