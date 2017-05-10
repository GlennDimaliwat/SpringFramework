package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a Query.. sort by last name
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		// Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// Return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save customer to database
		//currentSession.save(theCustomer);   //INSERT - supports save only
		//currentSession.update(theCustomer); //UPDATE - supports update only
		currentSession.saveOrUpdate(theCustomer); //BOTH - supports save or update
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Read the customer from database using the id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		// Return the customer
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete the customer from database using Query
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		//Perform the operation
		theQuery.executeUpdate();
		
		/*
		 * Alternate method but this requires 2 database operations which is slower
		 */
		/*
		// Read the customer from database using the id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		// Delete the customer from database
		currentSession.delete(theCustomer);
		*/
	}
	
}
