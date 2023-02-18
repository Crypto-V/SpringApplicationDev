package com.vas2code.springdemo;

public class AnotherFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Here is the another fortune service for you!";
	}

}
