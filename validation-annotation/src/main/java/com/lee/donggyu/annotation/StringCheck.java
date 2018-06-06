package com.lee.donggyu.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;	

import java.lang.annotation.*;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ConstraintTarget;
import com.lee.donggyu.validation.StringCheckValidation;
import com.lee.donggyu.validation.*;


@Documented
@Constraint(validatedBy = { StringCheckValidation.class })
// @Target({ ElementType.FIELD }) // TODO ElementType없이 작성하는 방법!
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME) // TODO RetentionPolicy없이 작성하는 방법!
public @interface StringCheck {
	String message() default "{com.lee.donggyu.annotation!!!}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
		
	CaseMode value();
	
//	@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
//	@Retention(RetentionPolicy.RUNTIME)
//	@Documented
//	@interface List {
//		StringCheck[] value();
//	}
}
