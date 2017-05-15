package com.glenndimaliwat.app.repository;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.glenndimaliwat.app.domain.Customer;

//@Repository
//public interface CustomerRepository extends CrudRepository<Customer, Integer> {
//@RepositoryRestResource ( path = "TheCustomers" ) // Just to Rename the Repository in the URI
@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

	List<Customer> findByFirstNameContaining(@Param("firstName") String firstName);
	
}
