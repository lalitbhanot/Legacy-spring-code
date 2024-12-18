package com.lalit.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.lalit.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@AfterReturning(pointcut = "execution(* com.lalit.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccount(JoinPoint theJoinPoint, List<Account> result) {

		
		String method = theJoinPoint.getSignature().toShortString() ;
		System.out.println("Method inside afterReturningFindAccount :::: "+ method);
		System.out.println("result inside afterReturningFindAccount"+result);
		
		// post processing the data and modifiying the data  
		//converting the account name to upper case
		convertAccountNamestoUpperCase(result);
		System.out.println("result inside afterReturningFindAccount after modification"+result);
		
	}

	private void convertAccountNamestoUpperCase(List<Account> result) {
		for(Account tempAccount :result)
		{
			// get uppercase
			String upperCaseName = tempAccount.getName().toUpperCase();
			tempAccount.setName("ModifiedName: "+ upperCaseName);
		}
		
	}

	@Before("execution(* com.lalit.aopdemo.dao.*.*(..))")
	public void beforeAddAccountwithAnyPackages() {
		System.out.println(
				" (8) ------Calling the before advice using specific return type, package,class,methods,params---");
	}

}
