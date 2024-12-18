package com.lalit.demoAnnotationWithXMLConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaterAnnotationBeanScopeApp {

	public static void main(String[] args) {
		//read the config file 
				ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
				//get bean  //default bean Name "TennisCoach" -> "tennisCoach"
				Coach coach = context.getBean("tennisCoachSetterInjection",Coach.class);
				Coach alphacoach = context.getBean("tennisCoachSetterInjection",Coach.class);
				//check if they are same. 
				boolean result =  (coach == alphacoach) ;
				//close the context
				System.out.println("result   "+ result);
				System.out.println("coach   "+coach);
				System.out.println("alphacoach  "+alphacoach);
				
				context.close();

	}

}
