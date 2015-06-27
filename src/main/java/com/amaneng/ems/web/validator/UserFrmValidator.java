/********************************************************************************
 *  COPYRIGHT (C) CLOUDSURFACE TECHNOLOGIES - 2012
 *
 *  The reproduction, transmission or use of this document or its contents is not
 *  permitted  without  express written  authority. Offenders will be  liable for
 *  damages. All rights, including rights created by patent grant or registration
 *  of a utility  model or design, are reserved. Technical modifications possible.
 *  Technical specifications  and  features are  binding only insofar as they are
 *  specifically and expressly agreed upon in a written contract.
 *
 ********************************************************************************/

package com.amaneng.ems.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amaneng.ems.web.form.UserFrm;
import static com.amaneng.ems.web.validator.ValidatorConstant.*;
/**
 * @author mraza
 * 
 */
@Component
public class UserFrmValidator implements Validator {
	
	
	@Override
	public boolean supports(Class c) {
		return UserFrm.class.isAssignableFrom(c);

	}

	@Override
	public void validate(Object command, Errors errors) {
		UserFrm userFrm = (UserFrm) command;
		if(LOGIN_VALIDATOR.equals(userFrm.getAction()))
			valideForLogin(userFrm, errors);
		if(ADD_VALIDATOR.equals(userFrm.getAction()))
			validateForRegister(userFrm, errors);
		
	}
	
	/**
	 * Validate login form
	 * @param userFrm
	 * @param errors
	 */
	private void valideForLogin(UserFrm userFrm, Errors errors){
		if(ValidationUtils.isEmpty(userFrm.getUserId())){
			errors.rejectValue("UserId", "3015", new Object[]{"Username"}, "");
			return;
		}
		if(ValidationUtils.isEmpty(userFrm.getPassword())){
			errors.rejectValue("Password", "3015", new Object[]{"Password"}, "");
			return;
		}
	}
	private void validateForRegister(UserFrm userFrm, Errors errors){
		
	}
}
