package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// CODE TO UPDATE ONE DATA
			// Input an id for a student to update
			int studentId = 1;
			
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve the student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			
			
			System.out.println("Get complete: " + myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			
			// CODE TO UPDATE MULTIPLE DATA
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'")
				.executeUpdate();
			
			//commit
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}

}
