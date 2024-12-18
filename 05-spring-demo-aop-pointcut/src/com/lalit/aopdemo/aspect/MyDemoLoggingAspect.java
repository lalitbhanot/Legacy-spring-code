package com.lalit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.lalit.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
		
	@Before("forDaoPackage()")
	public void beforeAddAccountwithAnyPackages()
	{
		System.out.println(" (1) ------Applying the PointCut ---");
	}
	
	
}
