package com.glenndimaliwat.app.service;

import com.glenndimaliwat.app.domain.Customer;

public interface CustomerCrudService {
	
	Iterable<Customer> list();
	
	Customer create(Customer customer);
	
	Customer read(int id);
	
	Customer update(int id, Customer customer);
	
	void delete(int id);
	
}
