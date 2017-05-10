package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//Load the Spring Configuration
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the Beans from the Container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//Check if objects are the same
		boolean result = (theCoach == alphaCoach);
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: "+ theCoach);
		System.out.println("\nMemory location for alphaCoach: "+ alphaCoach + "\n");
		
		//Close the context
		context.close();
	}

}
