package com.yes2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yes2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theForutneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\n Main Program: AroundDemoApp");

		myLogger.info(" Calling getFortune");
		String data = theForutneService.getFortune();
		myLogger.info("My fortune is " + data);
		myLogger.info("\nFinished!!!");

		// close the context
		context.close();
	}

}
