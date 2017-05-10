package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Call the business method
		theAccountDAO.addAccount();
		
		// Do it again!
		System.out.println("\n Let's call it again!\n");
		
		// Call the business method again
		theAccountDAO.addAccount();
				
		// Close the context
		context.close();

	}

}
