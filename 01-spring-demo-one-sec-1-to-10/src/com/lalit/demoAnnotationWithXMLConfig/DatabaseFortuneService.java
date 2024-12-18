package com.lalit.demoAnnotationWithXMLConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("databaseFortuneService")
public class DatabaseFortuneService implements FortuneService {

	@Override
	
	public String getFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
