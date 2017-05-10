package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GlennApp {

	public static void main(String[] args) {
		//Load Spring Configuration
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the Bean
		RandomFortuneService myRandomFortune = context.getBean("myRandomFortuneService", RandomFortuneService.class);
		RandomFortuneService myRandomFortune2 = context.getBean("myRandomFortuneService", RandomFortuneService.class);
		
		//Test beans if they are equal based on scope
		boolean result = (myRandomFortune == myRandomFortune2);
		System.out.println("Beans are Equal: "+result);
		System.out.println("Memory Location of myRandomFortune: " + myRandomFortune);
		System.out.println("Memory Location of myRandomFortune2: " + myRandomFortune2);	
		
		//Call methods
		System.out.println(myRandomFortune.getFortune());
		System.out.println(myRandomFortune2.getFortune());
		
		//Close the context
		context.close();
	}

}
