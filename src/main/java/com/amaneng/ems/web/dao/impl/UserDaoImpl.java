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

package com.amaneng.ems.web.dao.impl;

import com.amaneng.ems.web.entity.UserAccountEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amaneng.ems.web.dao.CstmEnitityManager;
import com.amaneng.ems.web.dao.UserDao;
import com.amaneng.ems.web.entity.DataObject;
import com.amaneng.ems.web.utility.EmsException;

/**
 * @author mraza
 * 
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private CstmEnitityManager enitityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amaneng.ems.web.dao.UserDao#login(com.amaneng.ems.web.entity
	 * .UserEntity)
	 */
	@Override
	public UserAccountEntity findUser(UserAccountEntity userEntity) throws EmsException {
		UserAccountEntity entity = (UserAccountEntity) enitityManager
				.findActiveVersion(userEntity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amaneng.ems.web.dao.UserDao#saveUser(com.amaneng.ems.web.entity
	 * .UserEntity)
	 */
	@Override
	public void saveUser(UserAccountEntity userEntity) throws EmsException {
		DataObject dobj = enitityManager.insert(userEntity);
	}

}
