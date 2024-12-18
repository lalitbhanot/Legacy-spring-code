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
	
	@Pointcut("execution(* com.lalit.aopdemo.dao.*.set*(..))")
	private void forSetter() {}
	
	@Pointcut("execution(* com.lalit.aopdemo.dao.*.get*(..))")
	private void forGetter() {}
	
	@Pointcut("forDaoPackage()&& !(forGetter()|| forSetter())")
	public void excludeGetterAndSetter () {}
	
	
		
	/*
	 * @Before("forDaoPackage()") public void beforeAddAccountwithAnyPackages() {
	 * System.out.
	 * println(" (1) ------Applying the PointCut  with getter and setter---"); }
	 */
	
	  @Before("excludeGetterAndSetter()") public void beforeAddAccount() {
	  System.out.
	  println(" (1) ------Applying the PointCut  excludeing the getter and setter---"
	  ); }
	 
	
	
	
}
