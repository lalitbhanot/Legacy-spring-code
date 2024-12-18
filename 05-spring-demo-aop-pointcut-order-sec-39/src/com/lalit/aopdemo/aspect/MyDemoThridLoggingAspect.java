package com.lalit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoThridLoggingAspect {
	
	  @Before("com.lalit.aopdemo.aspect.PointCutUtility.excludeGetterAndSetter()") public void performAnalysis() {
		  System.out.
		  println(" order (3) ------Applying the PointCut  excluding the getter and setter---"
		  ); }
		 
	
	
}
