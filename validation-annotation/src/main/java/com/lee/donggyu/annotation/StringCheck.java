package com.lee.donggyu.annotation;

import java.lang.annotation.*;

import javax.validation.Constraint;

import com.lee.donggyu.validation.*;



@Documented
@Constraint(validatedBy = { StringCheckValidation.class })
@Target({ ElementType.FIELD }) // METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER
@Retention(RetentionPolicy.RUNTIME) 
public @interface StringCheck {
    String message() default "Comment is not very goot";
     
}
