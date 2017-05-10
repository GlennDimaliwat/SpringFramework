package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// delete the student
			//System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);
			
			// Delete student id=2
			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}

}
