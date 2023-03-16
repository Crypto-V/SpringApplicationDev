package com.yes2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yes2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//Around advice will execute before and after method call
	@Around("execution(* com.yes2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n =======>>> Executing @Around on method: " + method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//now lets execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end  = System.currentTimeMillis();
		
		//compute the duration of the call and display it
		long duration = end - begin;
		myLogger.info("\n ====>> Duration: "+duration / 1000.0 + "seconds");
		
		return result;
	}
	

	// After acts like finally bloc, success or failure code will still execute.
	@After("execution(* com.yes2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(
			JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n =======>>> Executing After (finally) on method: " + method);

	}

	@AfterThrowing(
			pointcut = "execution(* com.yes2code.aopdemo.dao.AccountDAO.findAccounts(..))", 
			throwing = "exc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, 
			Throwable exc) {
		
		myLogger.info("In  after throwing");

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n =======>>> Executing After Throwing on method: " + method);

		// log the exception
		myLogger.info("\n =======>>> The exception is: " + exc);

	}

	@AfterReturning(
			pointcut = "execution(* com.yes2code.aopdemo.dao.AccountDAO.findAccounts(..))", 
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, 
			List<Account> result) {
		
		myLogger.info("In  after returning");

		// print pout which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n =======>> Executing AfterReturning on method: " + method);

		// print out the results of the method call
		myLogger.info("\n =======>> result is : " + result);

		// post-process the data and modify

		// convert the account names to all uppercase
		convertAccountNamesToUpperCase(result);

		myLogger.info("\n =======>> result after modification is : " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through the accounts
		for (Account theAccount : result) {

			// get the uppercase version
			String theUpperName = theAccount.getName().toUpperCase();

			// update the name on the account
			theAccount.setName(theUpperName);
		}

	}

	@Before("com.yes2code.aopdemo.aspect.YesAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);

		// display method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop through args and printing them out
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {
				// downcast and get data abut the account
				Account theAccount = (Account) tempArg;

				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}

	}

}
