package com.glenndimaliwat.app.service;

import java.util.List;

import com.glenndimaliwat.app.domain.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
	
}
