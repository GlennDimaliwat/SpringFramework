package com.glenndimaliwat.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glenndimaliwat.app.domain.Customer;
import com.glenndimaliwat.app.repository.CustomerRepository;

@Service
public class CustomerCrudServiceImpl implements CustomerCrudService {

	// Inject the Repository
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Iterable<Customer> list() {
		return customerRepository.findAll();
	}

	@Override
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer read(int id) {
		return customerRepository.findOne( id ); //Cast it to int for now
	}

	@Override
	public Customer update(int id, Customer updatedCustomer) {
		
		Customer customer = customerRepository.findOne( id );
		
		if( updatedCustomer.getFirstName() != null ) {
			customer.setFirstName(updatedCustomer.getFirstName());
		}
		if( updatedCustomer.getLastName() != null ) {
			customer.setLastName(updatedCustomer.getLastName());
		}
		if( updatedCustomer.getEmail() != null ) {
			customer.setEmail(updatedCustomer.getEmail());
		}
		
		return customerRepository.save(customer);
	
	}

	@Override
	public void delete(int id) {
		customerRepository.delete(id);

	}

}
