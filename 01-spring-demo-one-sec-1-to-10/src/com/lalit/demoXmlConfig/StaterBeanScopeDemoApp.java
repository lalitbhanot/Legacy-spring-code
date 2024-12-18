package com.lalit.demoXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaterBeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring Config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

		// retrive a bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		System.out.println( theCoach.getDailyWorkout());
		
		
		context.close();
		
	
	}

}
