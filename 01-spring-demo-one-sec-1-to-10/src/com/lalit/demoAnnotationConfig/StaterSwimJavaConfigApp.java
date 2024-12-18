package com.lalit.demoAnnotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class StaterSwimJavaConfigApp {
	public static void main(String[] args) { 
		//read the config file 
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(SportsConfig.class);
		//get bean  //default bean Name "TennisCoach" -> "tennisCoach"
	//	NewCoach newCoach =  context.getBean("swimCoach",NewCoach.class);
		SwimCoach newCoach =  context.getBean("swimCoach",SwimCoach.class);// see method in SportsConfig.java
		//close the bean 
		System.out.println(newCoach.getDailyWorkout());
		System.out.println(newCoach.getDailyFortune());
		System.out.println(newCoach.getEmail());
		System.out.println(newCoach.getTeam());
		//close the context
		context.close();
	}
}
