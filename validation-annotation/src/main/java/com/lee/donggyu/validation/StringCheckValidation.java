package com.lee.donggyu.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lee.donggyu.annotation.StringCheck;


public class StringCheckValidation implements ConstraintValidator<StringCheck, String> {

	@Override
	public void initialize(StringCheck constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !hasBadComment(value);
	}

	private boolean hasBadComment(final String comment) {
		List<String> badComment = new ArrayList<String>();
		badComment.add("sheet");

		if (badComment.stream().anyMatch(word -> comment.contains(word))) {
			return true;
		} else {
			return false;
		}
	}
}
