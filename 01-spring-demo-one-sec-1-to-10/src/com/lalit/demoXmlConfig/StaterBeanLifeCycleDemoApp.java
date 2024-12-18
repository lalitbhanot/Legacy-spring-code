package com.lalit.demoXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaterBeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// load the spring Config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrive a bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		
		// check if they are same 
		
		boolean result = (theCoach == alphaCoach) ;
		
		System.out.println("\n Pointing to same object " + result);
		
		System.out.println("\n location of Coach :   " + theCoach);
		System.out.println("\n Pointing alphaCoach :  " + alphaCoach);
		
		context.close();
		
	
	}

}
