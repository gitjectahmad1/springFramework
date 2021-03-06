package com.luv2code.aopdemo.aspecct;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all our advices for logging
	
	// let's start with an @Before 
	
	@Pointcut("execution(* com.luv2code.aopdemo..dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods 
	@Pointcut("execution(* com.luv2code.aopdemo..dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo..dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package and exclude... getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNogetterSetter() {}	
	
	
	@Before("forDaoPackageNogetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNogetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}
	

}
