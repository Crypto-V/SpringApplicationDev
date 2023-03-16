package com.yes2code.aopdemo.aspect;

import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	// Add a new advice for afterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.yes2code.aopdemo.dao.AccountDAO.findAccounts(..))", 
					returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, 
			List<Account> result) {

		
		//print pout which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =======>> Executing AfterReturning on method: "+ method);
		
		//print out the results of the method call
		System.out.println("\n =======>> result is : "+ result);
		
		//post-process the data and modify 
		
		//convert the account names to all uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n =======>> result after modification is : "+ result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		
		//loop through the accounts
		for(Account theAccount : result) {
			
			//get the uppercase version
			String theUpperName = theAccount.getName().toUpperCase();
			
			//update the name on the account
			theAccount.setName(theUpperName);
		}
		
		
		
	}

	@Before("com.yes2code.aopdemo.aspect.YesAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);

		// display method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop through args and printing them out
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and get data abut the account
				Account theAccount = (Account) tempArg;

				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}

	}

}
