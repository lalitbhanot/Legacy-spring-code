package com.lalit.demoAnnotationWithXMLConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("tennisCoach") 
/*this is explictly mentioned bean Name 
this is the example of default bean id ,
if the name is not mentioned then class name in lower case is taken
*/
@Component
//@Scope("prototype")
public class TennisCoachSetterInjection implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	public TennisCoachSetterInjection() {
		System.out.println("Inside setter injection");
	}
	
	@PostConstruct
	//@PostConstruct is not avaliable in java 9 updwards Need to manullay add javax.annotation-api-1.3.2.jar in the class path
	public void   PostConstruct() {
		System.out.println( "--This is an example for PostContruct--"); 
	}
	
	@PreDestroy
	//@PreDestroy is not avaliable in java 9 updwards Need to manullay add javax.annotation-api-1.3.2.jar in the class path
	public void  PreDestroy() {
		System.out.println( "--This is an example for PostContruct--"); 
	}

//Qualifier in place below the autowired in setter injection 
	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
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
