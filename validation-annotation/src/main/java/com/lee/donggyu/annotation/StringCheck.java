package com.lee.donggyu.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;	

import java.lang.annotation.*;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.lee.donggyu.validation.StringCheckValidation;
import com.lee.donggyu.validation.*;

/**
 * 
 * Whether user's input id already existed in DB.
 *
 */
//TODO @이름 바꾸기, isIDExisted 등 
@Documented
@Constraint(validatedBy = { StringCheckValidation.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE })  // java.lang.annotation.ElementType을 import안하면 ElementType.FIELD
@Retention(RUNTIME) 							// java.lang.annotation.RetentionPolicy를 import안하면 RetentionPolicy.RUNTIME
public @interface StringCheck {
	String message() default "{This ID is already exsited}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
		
	CaseMode value();
}
