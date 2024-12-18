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
		
		// call the business method
		accountDAO.addAccount();
		accountDAO.setServiceCode("011");
		accountDAO.setName("lalit");
		String Name = accountDAO.getName();
		String serviceCode =  accountDAO.getServiceCode();
		
		System.out.println(Name + "--" + serviceCode);
		
		
		// close the context
		context.close();

	}

}
