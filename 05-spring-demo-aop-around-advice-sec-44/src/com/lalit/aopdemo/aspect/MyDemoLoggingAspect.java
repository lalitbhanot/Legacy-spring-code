package com.lalit.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.lalit.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	@Around("execution(* com.lalit.aopdemo.service.*.getFortune(..))")
	public Object AroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("Method inside AroundGetFortune :::: " + method);

		System.out.println("------Calling the after advise ---");

		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();

		long duration = end - begin;
		System.out.println("At Around Advise " + duration);
		return result;
	}

	@After("execution(* com.lalit.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void AfterAdviceFindAccount(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("Method inside AfterAdviceFindAccount :::: " + method);

		System.out.println("------Calling the after advise ---");
	}

	@Before("execution(* com.lalit.aopdemo.dao.*.*(..))")
	public void beforeAddAccountwithAnyPackages() {
		System.out
				.println("------Calling the before advice using specific return type, package,class,methods,params---");
	}

}
