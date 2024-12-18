package com.lalit.demoXmlConfig;

public class FootballCoach implements Coach {

	private FortuneService fortuneService;

	private String email;
	private String team;

	// create a no args-constructor
	public FootballCoach() {
		System.out.println("Inside no arg constructor ");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Inside setEmail " + email);
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside team " + team );
		this.team = team;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Hit 5 goals";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
