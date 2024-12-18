package com.lalit.demoAnnotationConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.lalit.demoAnnotationConfig")
@PropertySource("classpath:sportsForAnnotations.properties")
public class SportsConfig {
	
	// define bean for our sad fortune service
	
	@Bean
	public FortuneService newFortuneService() {
		return new NewFortuneService();
	}
	
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public NewCoach swimCoach() {
		return new SwimCoach(newFortuneService()) ;
}
}