package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//Load the Spring Configuration File
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the Bean from Spring Container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//Call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//Call methods to see injected literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		//Call methods for Random Fortune
		System.out.println(theCoach.getRandomFortune());
		
		//Close the context
		context.close();
	}

}
