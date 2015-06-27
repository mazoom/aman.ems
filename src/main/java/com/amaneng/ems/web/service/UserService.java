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

package com.amaneng.ems.web.service;

import com.amaneng.ems.web.form.UserFrm;
import com.amaneng.ems.web.utility.EmsException;

/**
 * @author mraza
 *
 */
public interface UserService {
	
	public UserFrm login(UserFrm userForm) throws EmsException;

	public void addUser(UserFrm userForm) throws EmsException;
}
