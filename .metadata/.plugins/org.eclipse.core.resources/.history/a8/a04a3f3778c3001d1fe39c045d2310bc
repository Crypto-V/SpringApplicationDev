package com.yes2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yes2code.aopdemo.dao.AccountDAO;
import com.yes2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from srping container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		Account theAccount = new Account();

		// call the business method
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.doWork();

		// Call membership business method
		theMembershipDAO.addSillyAccount();
		theMembershipDAO.gotToSleep();

		// close context
		context.close();
	}

}
