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

package com.amaneng.ems.web.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amaneng.ems.web.annotation.CstmLogger;
import com.amaneng.ems.web.dao.DaoProvider;
import com.amaneng.ems.web.entity.UserAccountEntity;
import com.amaneng.ems.web.form.UserFrm;
import com.amaneng.ems.web.service.UserService;
import com.amaneng.ems.web.utility.EmsException;

/**
 * @author mraza
 * 
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	//private UserDao userDao;
	private DaoProvider daoProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@CstmLogger
	private Logger logger;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amaneng.ems.web.service.UserService#login(com.amaneng.ems.web
	 * .form.UserForm)
	 */
	@Override
	public UserFrm login(UserFrm userForm) throws EmsException {
		UserAccountEntity userEntity = transform(userForm);
		userEntity.setCreatedDate(null);
		userEntity.setCreatedBy(null);
		userEntity.setLastUpdatedBy(null);
		userEntity.setLastUpdatedDate(null);
		UserAccountEntity result = daoProvider.getUserDao().findUser(userEntity);
		if (result == null
				|| !passwordEncoder.isPasswordValid(result.getUserPasswrd(),
						userForm.getPassword(), null)){
			logger.error("Error : Invalid password.");
			throw EmsException.getTSException(3001);
		}
		UserFrm form = transform(result);
		logger.info("logged in user = " + form);
		logger.error("logged in user = " + form);
		return form;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amaneng.ems.web.service.UserService#addUser(com.inforayz.myjobtest
	 * .web.form.UserForm)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void addUser(UserFrm userForm) throws EmsException {
		UserAccountEntity userEntity = transform(userForm);
		daoProvider.getUserDao().saveUser(userEntity);
		logger.info("in service user has been added.");
	}

	/**
	 * @param userForm
	 * @return UserEntity
	 */
	private UserAccountEntity transform(UserFrm userForm) {
		UserAccountEntity userEntity = new UserAccountEntity();
		userEntity.setUserId(userForm.getUserId());
		String ecodedPassword = passwordEncoder.encodePassword(
				userForm.getPassword(), null);
		logger.info("Encoded Password====" + ecodedPassword);
		userEntity.setUserPasswrd(ecodedPassword);
		userEntity.setFirstName(userForm.getFirstName());
		userEntity.setLastName(userForm.getLastName());
		userEntity.setEmail(userForm.getEmail());
		userEntity.setCreatedBy("");
		userEntity.setLastUpdatedBy("");
		return userEntity;
	}

	/**
	 * @param userEntity
	 * @return UserForm
	 */
	private UserFrm transform(UserAccountEntity userEntity) {
		UserFrm userForm = new UserFrm();
		userForm.setUserId(userEntity.getUserId());
		userForm.setPassword(userEntity.getUserPasswrd());
		userForm.setFirstName(userEntity.getFirstName());
		userForm.setLastName(userEntity.getLastName());
		userForm.setEmail(userEntity.getEmail());
		return userForm;
	}

}
