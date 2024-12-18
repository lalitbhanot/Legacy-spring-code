package com.lalit.demoAnnotationConfig;

import org.springframework.stereotype.Component;

@Component("happyFortuneService")
public class HappyFortuneService implements FortuneService {

	@Override	
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Happy Fortune Service returns";
	}

}
