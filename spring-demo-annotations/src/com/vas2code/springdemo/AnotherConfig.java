package com.vas2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfig {

	// define bean for our sad fortune service
	@Bean
	public FortuneService anotherFortuneService() {
		return new AnotherFortuneService();
	}

	// define a bean for our swim coach AND inject dependency
	@Bean
	public Coach packingCoach() {
		return new PackingCoach(anotherFortuneService());
	}

	// define a bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(randomFortuneService());
	}
	
	@Bean
	public FortuneService randomFortuneService() {
		return new RandomFortuneService();
	}

}
