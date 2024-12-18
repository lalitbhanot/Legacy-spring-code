package com.lalit.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CoarseCodeConstraintValidator implements ConstraintValidator<CoarseCode, String> {

	private String coarsePrefix ;
	
	public void initialize (CoarseCode theCoarseCode)
	{
		coarsePrefix=theCoarseCode.value();
	}

	@Override
	public boolean isValid(String thecode, ConstraintValidatorContext arg1) {
		boolean result ;
		if (coarsePrefix!=null)
		{
			 result =thecode.startsWith(coarsePrefix);	
		}
		else {
			result = true;
		}
		
		return result;
	}

}
