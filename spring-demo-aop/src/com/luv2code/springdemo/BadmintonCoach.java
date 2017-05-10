package com.luv2code.springdemo;

public class BadmintonCoach implements Coach {

	FortuneService fortuneService;
	
	public BadmintonCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Perform smash warmups";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
