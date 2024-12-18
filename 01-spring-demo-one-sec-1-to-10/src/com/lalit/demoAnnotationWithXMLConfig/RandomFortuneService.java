package com.lalit.demoAnnotationWithXMLConfig;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("randomFortuneService")
public class RandomFortuneService implements FortuneService {
// create an array of strings
	private String [] data = {"beware of cats","nacho zor zor se","journey is the reward"} ;
	private Random myrandom = new Random() ;
	@Override
	public String getFortune() {
	//create a Random number  generator 
		int index = myrandom.nextInt(data.length);
		String randomFortune = data[index];
		return randomFortune ;
	}

}
