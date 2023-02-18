package com.vas2code.springdemo;

public class PackingCoach implements Coach {

	private FortuneService fortuneService;
	
	

	public PackingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "pack 300 boxes in 1 minute";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
