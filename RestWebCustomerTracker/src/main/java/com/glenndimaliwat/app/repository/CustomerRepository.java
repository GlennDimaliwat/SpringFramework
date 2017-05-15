package com.glenndimaliwat.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glenndimaliwat.app.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	// Get all customers and order by Last Name in ascending order
	List<Customer> findAllByOrderByLastNameAsc();
	
}
