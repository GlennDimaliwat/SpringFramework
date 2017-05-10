package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {	
			// Start a transaction
			session.beginTransaction();
			
			// Query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// Display the students
			displayStudents(theStudents);
			
			// Query students: lastName='Doe'
			theStudents = session.createQuery("from Student s WHERE s.lastName='Doe'").getResultList();
			
			// Display the students
			System.out.println("\n\nStudents who has the last name of Doe");
			displayStudents(theStudents);
			
			// Query students: lastName='Doe' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where"
										+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			// Display the students
			System.out.println("\n\nStudents who has the last name of Doe or first name of Daffy");
			displayStudents(theStudents);
			
			// Query student where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s WHERE"
									+ " s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\nStudents who have an email that ends with gmail.com");
			displayStudents(theStudents);
			
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
