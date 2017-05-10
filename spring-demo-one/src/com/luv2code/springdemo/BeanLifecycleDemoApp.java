package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		//Load the Spring Configuration
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		//Retrieve Beans from Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//Call methods
		System.out.println(theCoach.getDailyWorkout());
		
		//Close the Context
		context.close();
	}

}
