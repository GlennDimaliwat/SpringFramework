package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//Load the Spring Configuration
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//Retrieve Beans from Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//Check if these are the same beans
		boolean result = (theCoach == alphaCoach);
		
		//Display result
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory Location for theCoach: " + theCoach);
		System.out.println("\nMemory Location for alphaCoach: " + alphaCoach);
		
		//Close the Context
		context.close();
	}

}
