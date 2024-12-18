package com.lalit.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.lalit.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.lalit.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.lalit.springdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		String theMethod =theJoinPoint.getSignature().toShortString() ;
		myLogger.info("Inside the before aspect ::::"+ theMethod);
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void after(JoinPoint theJoinPoint,Object theResult)
	{
		String theMethod =theJoinPoint.getSignature().toShortString() ;
		myLogger.info("Inside the after aspect result ::::"+ theResult);
		myLogger.info("Inside the after aspect ::::"+ theMethod);
		
	}
	
}
