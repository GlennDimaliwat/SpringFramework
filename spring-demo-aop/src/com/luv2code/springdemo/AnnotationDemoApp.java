package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//Read the Spring Configuration
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Get the Bean from Spring Container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//Get the SwimCoach Bean
		SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Call method for fortune
		System.out.println(theCoach.getDailyFortune());
		
		//Call methods for swim coach
		/*System.out.println(theSwimCoach.getEmail());
		System.out.println(theSwimCoach.getTeam());*/
		
		//Close the Context
		context.close();
	}

}
