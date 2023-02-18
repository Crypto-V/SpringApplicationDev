package com.vas2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//Create array of strings
	private String[] data = {
			"Beware of the walf in granny\'s cloths",
			"Diligence is the motehrs of everything",
			"The journey is te reward"
	};
	
	
	//Create a random number generator
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		//pick random string from array
		int index =  myRandom.nextInt(data.length);
		
		String theFortune =  data[index];
		
		return theFortune;
	}

}
