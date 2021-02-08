package Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sun.mail.handlers.message_rfc822;

public class PhoneNumberValidationConstraint implements ConstraintValidator<PhoneValidation, String>{
	
	private String message;
	
	@Override
	public void initialize(PhoneValidation constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		System.out.println("check valid phone");
		System.out.println("phone # is" + phoneNumber);

		if (phoneNumber == null) {
			System.out.println("cannot be null");
			return false;
		}
		if (!phoneNumber.matches("[0123456789]+")) {
			message = "Only numbers can be used";
			return false;
		}
		if(phoneNumber.charAt(0) == '0' )
		{
			message = "Phone Number can not start with 0";
			return false;
		}

		return true;
	}

}
