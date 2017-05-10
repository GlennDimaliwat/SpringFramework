package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		Random random = new Random();
		String[] fortuneArray = {"You are very lucky",
								"You are a bit lucky",
								"You are not lucky"};
		
		int randomNumber = random.nextInt(3);
		
		// Return random fortune
		return fortuneArray[randomNumber];
	}
	
	public void startupStuff() {
		System.out.println("RandomFortuneService: inside method = startupStuff");
	}
	
	public void shutdownStuff() {
		System.out.println("RandomFortuneService: inside method = shutdownStuff");
	}

}
