package com.packt.webstore.validator;

 	import org.springframework.validation.Errors;
	import org.springframework.validation.ValidationUtils;
	import org.springframework.validation.Validator;

	import com.packt.webstore.domain.Member;

	public class MemberValidator implements Validator {

		// Can this Validator validate instances of the supplied class? 
		@Override
		public boolean supports(Class<?> c) {
			return Member.class.isAssignableFrom(c);
		}

		@Override
		public void validate(Object command, Errors errors) {
			String[] errorArgs = {"First Name"};
	 		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty",errorArgs);		
	 		errorArgs = new String[]{"Last Name"};

			//lastName is property of Member class, NotEmpty is errorcode, errorArgs connect with properties file and variable

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty",errorArgs);
 			Member member = (Member)command;
			if( member.getMemberNumber() == null ||
					member.getMemberNumber() <= 0)
				errors.rejectValue("memberNumber","Member.Number.lessthan");
			if( member.getAge() <  18)
				errors.rejectValue("age","Member.age");
 		}

 	}
