package com.vas2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create OB
		Coach theCoach = new TrackCoach();

		// Use OB

		System.out.println(theCoach.getDailyWorkout());
	}

}
