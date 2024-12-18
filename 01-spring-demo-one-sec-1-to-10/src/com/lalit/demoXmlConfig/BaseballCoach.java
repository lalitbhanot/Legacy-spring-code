package com.lalit.demoXmlConfig;


public class BaseballCoach implements Coach {
	
	// Define a private field and then add a constructor 
	
	private FortuneService fortuneService ;
	
	//define a constructor 
	public  BaseballCoach(FortuneService thefortuneService) {
		fortuneService =thefortuneService ;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use the fortuneService to get the a fortune 
		return fortuneService.getFortune();
	}

}








