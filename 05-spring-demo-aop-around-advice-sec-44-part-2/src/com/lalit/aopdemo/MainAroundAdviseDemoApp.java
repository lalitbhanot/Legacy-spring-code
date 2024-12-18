package com.lalit.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lalit.aopdemo.dao.AccountDAO;
import com.lalit.aopdemo.service.TrafficFortuneService;

public class MainAroundAdviseDemoApp {

	public static void main(String[] args) {

		// read the config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService = null;
		boolean tripwire = true ;
		// get the bean
		try {
			trafficFortuneService=	context.getBean("trafficFortuneService", TrafficFortuneService.class);
		// close the context
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String fortune = trafficFortuneService.getFortune(tripwire);
		System.out.println("fortune:::: " + fortune);
		context.close();

	}

}
