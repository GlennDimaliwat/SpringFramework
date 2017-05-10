package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Read the Spring Configuration
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//Get the Bean from Spring Container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Call method for fortune
		System.out.println(theCoach.getDailyFortune());
		
		//Output the properties values
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		//Close the Context
		context.close();
	}

}
