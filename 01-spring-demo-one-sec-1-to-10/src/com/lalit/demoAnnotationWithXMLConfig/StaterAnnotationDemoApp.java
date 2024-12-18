package com.lalit.demoAnnotationWithXMLConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaterAnnotationDemoApp {

	public static void main(String[] args) { 
		//read the config file 
		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
		//get bean  //default bean Name "TennisCoach" -> "tennisCoach"
		Coach coach = context.getBean("tennisCoachSetterInjection",Coach.class);
		//close the bean 
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		//close the context
		context.close();
	}
	
	
}
