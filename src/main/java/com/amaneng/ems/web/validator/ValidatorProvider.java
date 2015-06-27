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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mraza
 *
 */
@Component
public class ValidatorProvider {

	@Autowired
	private UserFrmValidator userFrmValidator;

	public UserFrmValidator getUserFrmValidator() {
		return userFrmValidator;
	}

	public void setUserFrmValidator(UserFrmValidator userFrmValidator) {
		this.userFrmValidator = userFrmValidator;
	}
	
}
