package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BadmintonDemoApp {

	public static void main(String[] args) {
		// Load the Spring Configuration
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(BadmintonSportConfig.class);
		
		// Retrieve the Beans
		Coach theCoach = context.getBean("badmintonCoach", Coach.class);
		
		// Call the Methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// Close the Context
		context.close();
	}

}
