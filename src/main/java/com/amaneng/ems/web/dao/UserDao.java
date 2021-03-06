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

package com.amaneng.ems.web.dao;

import com.amaneng.ems.web.entity.UserAccountEntity;

import com.amaneng.ems.web.utility.EmsException;

/**
 * @author mraza
 * 
 */

public interface UserDao {

	UserAccountEntity findUser(UserAccountEntity userEntity) throws EmsException;

	void saveUser(UserAccountEntity userEntity) throws EmsException;
}
