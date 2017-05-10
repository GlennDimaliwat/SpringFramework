package com.glenndimaliwat.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.glenndimaliwat.hibernate.entity.Employee;

public class CreateEmployeeApp {

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
			System.out.println("Creating New Employee...");
			//Create employee object
			Employee theEmployee = new Employee("Glenn","Dimaliwat","Google");
			
			//Start transaction
			session.beginTransaction();
			
			//Save the employee object
			System.out.println("Saving the employee");
			session.save(theEmployee);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
	}

}
