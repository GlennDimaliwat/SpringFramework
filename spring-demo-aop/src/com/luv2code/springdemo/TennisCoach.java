package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	// Field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// Default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}
	// Constructor Injection
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// Define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: inside doMyStartupStuff()");
	}
	
	// Define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: inside doMyCleanupStuff()");
	}
	
	// Setter Injection
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}*/
	
	//Any method injection
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}*/

}
