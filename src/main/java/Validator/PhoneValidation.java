package Validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = PhoneNumberValidationConstraint.class)
public @interface PhoneValidation {
	
	
String message() default "{not a valid phone number}";
	
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
