package com.yes2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yes2code.aopdemo.dao.AccountDAO;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advises for logging

	// starting with @Before advice
	// * wildcard pattern, any method that starts with add

//	@Before("execution(public void add*())")

	@Pointcut("execution(* com.yes2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// Create a pointcut to match on getter and setters
	@Pointcut("execution(* com.yes2code.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* com.yes2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// Create a combined pointcut to include package and exclude getters and setters.
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println(
				"\n =======> testing on getter and setter");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n testing on getter and setter, inside the perform analytics method");
	}

}
