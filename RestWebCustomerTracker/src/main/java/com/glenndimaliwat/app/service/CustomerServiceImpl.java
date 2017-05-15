package com.glenndimaliwat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glenndimaliwat.app.domain.Customer;
import com.glenndimaliwat.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Inject the Repository
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// Get all customers
		//return (List<Customer>) customerRepository.findAll();
		
		// Get all customers ordered by last name ascending
		return customerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// Save a customer
		customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// Get a customer
		return customerRepository.findOne(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		// Delete a customer
		customerRepository.delete(theId);

	}

}
