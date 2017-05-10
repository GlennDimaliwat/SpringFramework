package com.glenndimaliwat.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.glenndimaliwat.hibernate.entity.Employee;

public class DeleteEmployeeAllApp {

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
			System.out.println("Deleting all employees...");
			
			//Start transaction
			session.beginTransaction();
			
			//Delete all data from table
			session.createQuery("delete from Employee").executeUpdate();
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		}
		finally {
			factory.close();
		}
	}

}
