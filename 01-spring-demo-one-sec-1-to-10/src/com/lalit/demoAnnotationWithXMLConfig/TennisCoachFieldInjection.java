package com.lalit.demoAnnotationWithXMLConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("tennisCoach") // this is explictly mentioned bean Name 
@Component // this is the example of default bean id ,
			// if the name is not mentioned then class name in lower case is taken

public class TennisCoachFieldInjection implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;



	@Override
	public String getDailyWorkout() {
		return "Practice Tennis";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
