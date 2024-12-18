package com.lalit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.lalit.aopdemo.aspect.PointCutUtility.forDaoPackage()")
	public void beforeAddAccountwithAnyPackages() {
		System.out.println(" order (1) ------Applying the PointCut  with getter and setter---");
	}

}
