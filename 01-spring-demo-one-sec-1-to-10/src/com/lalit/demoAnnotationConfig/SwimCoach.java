package com.lalit.demoAnnotationConfig;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements NewCoach {
	
	private FortuneService fortuneService ;

	@Value("${foo.email}")
	private String Email ;
	@Value("${foo.team}")
	private String Team ;
	
	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		 return "Swim 1000 meters as a warmup";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTeam() {
		return Team;
	}

	public void setTeam(String team) {
		Team = team;
	}

	

}
