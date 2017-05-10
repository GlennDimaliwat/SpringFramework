package com.glenndimaliwat.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.glenndimaliwat.hibernate.entity.Employee;

public class ReadEmployeeMultipleApp {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		//Commit transaction
		try {
			System.out.println("Reading Employees...");	
			//Start transaction
			session.beginTransaction();
			
			//Read and display the employee object
			System.out.println("\n\nRead and display the employee object");
			List<Employee> theEmployee = session.createQuery("from Employee").getResultList();
			displayEmployees(theEmployee);
			
			//Read and display the employee object where first name is Glenn
			System.out.println("\n\nRead and display the employee object where first name is Glenn");
			theEmployee = session.createQuery("from Employee e where"
														+ " e.firstName='Glenn'").getResultList();
			displayEmployees(theEmployee);
			
			//Read and display the employee object where first name is Glenn OR last name is Jobs
			System.out.println("\n\nRead and display the employee object where first name is Glenn OR last name is Jobs");
			theEmployee = session.createQuery("from Employee e where"
														+ " e.firstName='Glenn'"
														+ " OR e.lastName='Jobs'").getResultList();
			displayEmployees(theEmployee);
			
			//Read and display the employee object where company ends with 'e'
			System.out.println("\n\nRead and display the employee object where company ends with 'e'");
			theEmployee = session.createQuery("from Employee e where"
														+ " e.company LIKE '%e'").getResultList();
			displayEmployees(theEmployee);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> theEmployee) {
		for(Employee tempEmployee : theEmployee) {
			System.out.println(tempEmployee);
		}
	}

}
