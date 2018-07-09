/******************************************************************
 *  
 * This code is for the Income verification project.
 *
 * 
 * © 2018, EQB Management All rights reserved. 
 * 
 * 
 ******************************************************************/

package co.ppk.validators;

import co.ppk.dto.CustomerDto;
import co.ppk.enums.Codes;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class CustomerValidator extends BaseValidator implements Validator {

	/*
	 * This method validates the login data
	 * 
	 * @return void no value is returning.
	 */
	@Override
	public void validate(Object target, Errors errors) {

		CustomerDto customer = (CustomerDto) target;
		if (StringUtils.isEmpty(customer.getIdentification())) {
			errors.rejectValue("identification", Codes.IDENTIFICATION_CANNOT_BE_NULL.getErrorCode());
		}

		if (StringUtils.isEmpty(customer.getName())) {
			errors.rejectValue("name", Codes.NAME_CANNOT_BE_NULL.getErrorCode());
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerDto.class.equals(clazz);
	}
}