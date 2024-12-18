package com.lalit.demoAnnotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class StaterConfigApp {
	public static void main(String[] args) { 
		//read the config file 
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(SportsConfig.class);
		//get bean  //default bean Name "TennisCoach" -> "tennisCoach"
		NewCoach newCoach =  context.getBean("tennisCoachSetterInjection",NewCoach.class);
		//close the bean 
		System.out.println(newCoach.getDailyWorkout());
		System.out.println(newCoach.getDailyFortune());
		//close the context
		context.close();
	}
}
