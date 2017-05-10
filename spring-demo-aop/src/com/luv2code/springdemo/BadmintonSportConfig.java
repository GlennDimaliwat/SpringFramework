package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BadmintonSportConfig {

	//Define Bean for Badminton Fortune Service
	@Bean
	FortuneService badmintonService() {
		return new BadmintonFortuneService();
	}
	
	//Define Bean for Badminton Coach and Inject Dependency
	@Bean
	public Coach badmintonCoach() {
		return new BadmintonCoach( badmintonService() );
	}
}
