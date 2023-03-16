package com.yes2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yes2code.aopdemo.dao.AccountDAO;
import com.yes2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			
			//add a boolean flag to simulate the exception
			boolean tripWire  = true;
			theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception e) {
			System.out.println("\n\n Main program caught exception" + e);
		}
		
		
		//Display the accounts
		System.out.println("\n\n Main program: After Finally Demo App");
		System.out.println("---------------");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
	}

}










