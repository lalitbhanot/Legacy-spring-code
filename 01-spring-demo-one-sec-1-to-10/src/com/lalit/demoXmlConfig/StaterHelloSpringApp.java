package com.lalit.demoXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaterHelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring Config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrive a bean from spring container
	//	Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theCoach = context.getBean("myTrackCoach", Coach.class);
		
		// call the methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		// method for fortune service 
		System.out.println(theCoach.getDailyFortune());
		// close the context
		context.close();
	}

}
