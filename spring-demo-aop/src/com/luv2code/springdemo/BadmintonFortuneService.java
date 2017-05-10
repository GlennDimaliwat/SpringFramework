package com.luv2code.springdemo;

public class BadmintonFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You will most likely win today in Badminton!";
	}

}
