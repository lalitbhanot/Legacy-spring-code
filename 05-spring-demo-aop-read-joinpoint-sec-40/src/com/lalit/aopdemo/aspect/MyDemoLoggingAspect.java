package com.lalit.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lalit.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.lalit.aopdemo.aspect.PointCutUtility.forDaoPackage()")
	public void beforeAddAccountwithAnyPackages(JoinPoint theJoinPoint) {
		System.out.println(" order (1) ------Applying the PointCut  with getter and setter---");
		
		//display the method signature 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method Signature :: "+methodSig);
		//display the method arguments
		Object [] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				Account theaccount = (Account) tempArg ;
				System.out.println("account Name :::::::::"+ theaccount.getName());
				System.out.println("account Level:::::::::"+theaccount.getLevel());
			}
		}
		
		
	}

}
