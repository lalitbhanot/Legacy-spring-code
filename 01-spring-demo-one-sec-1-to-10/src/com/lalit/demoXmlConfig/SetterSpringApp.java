package com.lalit.demoXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterSpringApp {

	public static void main(String[] args) {
		
		// load the spring Config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrive a bean from spring container
		FootballCoach coach = context.getBean("myFootballCoach",FootballCoach.class) ;
		
		// call the methods on bean
		System.out.println(coach.getDailyWorkout());
		
		// method for fortune service 
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getEmail());
		
		
		System.out.println(coach.getTeam());
		
		
		// close the context
		context.close();
	}

}
