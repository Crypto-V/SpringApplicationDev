package com.yes2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//starting with @Before advice
	//* wildcard pattern, any method that starts with add
	
//	@Before("execution(public void add*())")
	
	
	
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println
				(
				"\n =======> This code runned from Aspect MyDemoLoggingAspect"
				+" before the addAccount Method."
				);
	}

}
