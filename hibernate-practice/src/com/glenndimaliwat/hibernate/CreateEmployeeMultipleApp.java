package com.glenndimaliwat.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.glenndimaliwat.hibernate.entity.Employee;

public class CreateEmployeeMultipleApp {

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
			System.out.println("Creating New Employees...");
			//Create employee object
			Employee theEmployee1 = new Employee("Steve","Jobs","Apple");
			Employee theEmployee2 = new Employee("Bill","Gates","Microsoft");
			Employee theEmployee3 = new Employee("Mark","Zuckerberg","Facebook");
			
			//Start transaction
			session.beginTransaction();
			
			//Save the employee object
			System.out.println("Saving the employees");
			session.save(theEmployee1);
			session.save(theEmployee2);
			session.save(theEmployee3);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
	}

}
