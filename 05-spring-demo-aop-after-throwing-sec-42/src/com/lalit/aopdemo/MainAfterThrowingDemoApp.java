package com.lalit.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lalit.aopdemo.dao.AccountDAO;

public class MainAfterThrowingDemoApp {

	public static void main(String[] args) {

		// read the config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the business method
		List<Account> findAccount = null;
		try {
			boolean tripWire =true ; 
			findAccount = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(" in main Program findAccount:::" + findAccount);
		// close the context
		context.close();

	}

}
