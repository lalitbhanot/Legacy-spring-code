package com.lalit.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lalit.aopdemo.dao.AccountDAO;
import com.lalit.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read the config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		// call the business method
		accountDAO.addAccount();
		accountDAO.addCutomer();
		accountDAO.addAccount(new Account());
		accountDAO.addAccount(new Account(),true);
		System.out.println("\n Calling Again from membership class \n ");
		membershipDAO.addAccount();
		// close the context
		context.close();

	}

}
