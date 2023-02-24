package com.vas2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//Define default course code
	public String value() default "LUV";
	
	//Define default errors message
	public String message() default "must start with LUV";
	
	//Define default groups
	public Class<?>[] groups() default{};
	
	//Define default payloads
	public Class<? extends Payload> [] payload() default {};
}
