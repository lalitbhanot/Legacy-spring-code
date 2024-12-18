package com.lalit.demoAnnotationWithXMLConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("tennisCoach") // this is explictly mentioned bean Name 
@Component // this is the example of default bean id ,
			// if the name is not mentioned then class name in lower case is taken

public class TennisCoachConstructorInjection implements Coach {



	
	private FortuneService fortuneService;

	@Autowired
	//when using the constructor injection along with qualifier annotaion then at that time the this is the format for decalring it 
	public TennisCoachConstructorInjection(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

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
