package com.vas2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class PickingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Pick faster mutherfucker";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
