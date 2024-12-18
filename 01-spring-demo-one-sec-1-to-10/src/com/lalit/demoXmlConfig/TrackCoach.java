package com.lalit.demoXmlConfig;


public class TrackCoach implements Coach {
	
	// Define a private field and then add a constructor 
	
		private FortuneService fortuneService ;
		
		//define a constructor 
		public  TrackCoach(FortuneService thefortuneService) {
			fortuneService =thefortuneService ;
			// TODO Auto-generated constructor stub
		}
		
		
		public  TrackCoach() {}
		

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return " Nacho :: "+ fortuneService.getFortune();
	}

	
	
	//adding a init method 
	public void  initMethod ()
	{
		System.out.println("I am inside initMethod for TrackCoach Classs");
	}
	//adding a destroy method
	public void destroyMethod ()
	{
		System.out.println("I am inside destroyMethod for TrackCoach Classs");
	}

}










