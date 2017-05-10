package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private RandomFortuneService randomFortuneService;
	
	//add new fields for emailAddress and team
	private String emailAddress;
	private String team;
	
	//Create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	//create setter methods for literal injections
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	//Our setter method for setter injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	//Setter method for random fortune
	public void setRandomFortuneService(RandomFortuneService randomFortuneService) {
		System.out.println("CricketCoach: inside setter method - setRandomFortuneService");
		this.randomFortuneService = randomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getRandomFortune() {
		return randomFortuneService.getFortune();
	}

}
