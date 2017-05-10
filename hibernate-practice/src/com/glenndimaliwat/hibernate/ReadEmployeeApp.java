package com.glenndimaliwat.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.glenndimaliwat.hibernate.entity.Employee;

public class ReadEmployeeApp {

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
			System.out.println("Reading Employee...");
			//Enter employee no.
			int employeeId = 1;
			
			//Start transaction
			session.beginTransaction();
			
			//Read the employee object
			Employee theEmployee = session.get(Employee.class, employeeId);
			
			//Output the result
			System.out.println(theEmployee);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
	}

}
