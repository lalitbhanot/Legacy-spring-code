package com.lalit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//At Before advice for any account method 
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice()
	{
		System.out.println(" (1) -Calling the before advice----");
	}
	
	
	
	@Before("execution(public void com.lalit.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeSpecificAddAccountAdvice()
	{
		System.out.println(" (2) --Calling the before advice only for account DAO object----");
	}
	
	@Before("execution(public void add*())")
	public void beforeWildCardAddAccountAdvice()
	{
		System.out.println(" (3) ---Calling the before advice using wildcard add*---");
	}
	
	@Before("execution(* add*())")
	public void beforeWildCardReturnAdvice()
	{
		System.out.println(" (4) ----Calling the before advice using wildcard return type *---");
	}
	
	@Before("execution(* add*(com.lalit.aopdemo.Account))")
	public void beforeAddAccountwithOneParameter()
	{
		System.out.println(" (5) -----Calling the before advice using wildcard paramter type *---");
	}

	@Before("execution(* add*(com.lalit.aopdemo.Account,..))")
	public void beforeAddAccountwithMultipleParameters()
	{
		System.out.println(" (6) ------Calling the before advice using wildcard paramter type for multiple parameters *---");
	}
	
	@Before("execution(* add*(com.lalit.aopdemo.Account,..))")
	public void beforeAddAccountwithAnyParameters()
	{
		System.out.println(" (7) ------Calling the before advice using wildcard paramter type for Any number of  parameters *---");
	}
	
	@Before("execution(* com.lalit.aopdemo.dao.*.*(..))")
	public void beforeAddAccountwithAnyPackages()
	{
		System.out.println(" (8) ------Calling the before advice using specific return type, package,class,methods,params---");
	}
	
	
}
