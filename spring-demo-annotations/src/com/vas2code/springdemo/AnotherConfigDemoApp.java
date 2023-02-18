package com.vas2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnotherConfigDemoApp {

	public static void main(String[] args) {

		// Use java spring configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnotherConfig.class);

		// get the bean from spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		Coach packingCoach = context.getBean("packingCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		boolean compare = (theCoach == packingCoach);
		
		System.out.println(theCoach.toString());
		System.out.println(packingCoach.toString());
		
		System.out.println("is coach same as packingCoach: "+compare);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(packingCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println(packingCoach.getDailyFortune());
		
	

		// close context
		context.close();
	}

}
