package com.lee.donggyu.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lee.donggyu.annotation.StringCheck;

public class StringCheckValidation implements ConstraintValidator<StringCheck, String> {
	private CaseMode caseMode;

	@Override
	public void initialize(StringCheck constraintAnnotation) {
		this.caseMode = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		// System.out.println("after valid");

		if(object == null) {
			return true;
		}
		
		boolean isValid = false;
		if(caseMode == CaseMode.UPPER) {
			isValid =  object.equals(object.toUpperCase());
		} else {
			isValid = object.equals(object.toLowerCase());
		}
		
		if(!isValid) {
			// constraintContext.disableDefaultConstraintViolation();
            // constraintContext.buildConstraintViolationWithTemplate( "{com.lee.donggyu.annotation.StringCheck.message}"  ).addConstraintViolation();
		}
		return isValid;
		//
		// boolean isValid;
		//
		// if (caseMode == CaseMode.UPPER) {
		// // return object.equals(object.toUpperCase());
		// isValid = object.equals(object.toUpperCase());
		// } else {
		// // return object.equals(object.toLowerCase());
		// isValid = object.equals(object.toLowerCase());
		// }
		//
		// // TODO 아래 코드 이해하기.
		// if (!isValid) {
		// System.out.println("is not valid");
		// constraintContext.disableDefaultConstraintViolation();
		// constraintContext.buildConstraintViolationWithTemplate("add error
		// message").addConstraintViolation();
		// }
		//
		// return isValid;

		// }
	}
}
