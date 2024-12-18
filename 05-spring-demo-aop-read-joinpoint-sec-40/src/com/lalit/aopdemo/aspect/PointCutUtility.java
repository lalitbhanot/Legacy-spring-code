package com.lalit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutUtility {

	@Pointcut("execution(* com.lalit.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.lalit.aopdemo.dao.*.set*(..))")
	public  void forSetter() {}
	
	@Pointcut("execution(* com.lalit.aopdemo.dao.*.get*(..))")
	public void forGetter() {}
	
	@Pointcut("forDaoPackage()&& !(forGetter()|| forSetter())")
	public void excludeGetterAndSetter () {}
	
	
}
