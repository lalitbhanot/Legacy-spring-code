package com.lalit.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.lalit.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@AfterThrowing(pointcut = "execution(* com.lalit.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExec")
	public void afterThrowingFindAccount(JoinPoint theJoinPoint, Throwable theExec) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("Method inside afterThrowingFindAccount :::: " + method);
		
		System.out.println("Exeception  inside afterThrowingFindAccount :::: " + theExec);

		
		
	}

	

		@Before("execution(* com.lalit.aopdemo.dao.*.*(..))")
	public void beforeAddAccountwithAnyPackages() {
		System.out.println(
				" (8) ------Calling the before advice using specific return type, package,class,methods,params---");
	}

}
