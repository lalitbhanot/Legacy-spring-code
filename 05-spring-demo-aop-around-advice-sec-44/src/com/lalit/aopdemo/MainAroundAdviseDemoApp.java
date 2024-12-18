package com.lalit.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lalit.aopdemo.dao.AccountDAO;
import com.lalit.aopdemo.service.TrafficFortuneService;

public class MainAroundAdviseDemoApp {

	public static void main(String[] args) {

		// read the config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		// close the context
		
		String fortune = trafficFortuneService.getFortune();
		System.out.println("fortune:::: " + fortune);
		context.close();

	}

}
