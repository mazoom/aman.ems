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

package com.amaneng.ems.web.controller;

import static com.amaneng.ems.web.utility.ResourceConstant.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.amaneng.ems.web.annotation.CstmLogger;
import com.amaneng.ems.web.form.UserFrm;
import com.amaneng.ems.web.service.ServiceProvide;
import com.amaneng.ems.web.utility.EmsConstants;
import com.amaneng.ems.web.utility.EmsException;
import com.amaneng.ems.web.validator.ValidatorConstant;
import com.amaneng.ems.web.validator.ValidatorProvider;

/**
 * @author mraza
 * 
 */
@Controller
@SessionAttributes("userFrm")
//@RequestMapping("/user")
public class UserContoller {

	@Autowired 
	private ServiceProvide serviceProvide;
	
	@Autowired
	private ValidatorProvider validatorProvider;
	
	@CstmLogger
	private Logger logger;
	

	@RequestMapping(value = FRM_SIGNINF_ACTION, method = RequestMethod.GET)
	public String showSignInForm(ModelMap model) {
		UserFrm userForm=new UserFrm();
		
		model.addAttribute("userFrm", userForm);
		return AUTHENTICATE_PAGE;
	}

	@RequestMapping(value = EMPLOYEE_SIGNIN_ACTION, method = RequestMethod.POST)
	public ModelAndView jobEmpolyeeLogin(@Valid @ModelAttribute("userFrm") UserFrm userFrm,
			BindingResult result,  HttpServletRequest request) {
		logger.info("** result.hasErrors() ** "+result.hasErrors()); // always false
		userFrm.setAction(ValidatorConstant.LOGIN_VALIDATOR);
		validatorProvider.getUserFrmValidator().validate(userFrm, result);
		if(result.hasErrors()){
			return new ModelAndView(AUTHENTICATE_PAGE);
		}
		try{
			userFrm.setUserType(EmsConstants.EMPLOYEE_USER);
			login(userFrm, request);
		} catch (EmsException e) {
			result.reject(e.getErrorCode());
			//return new ModelAndView("redirect:/"+SIGNIN_ACTION);
			return new ModelAndView(MAIN_PAGE);
		}
		return new ModelAndView("redirect:/"+EMPLOYEE_DASHBOARD_ACTION);
	}
	
	private UserFrm login(UserFrm userFrm,  HttpServletRequest request)throws EmsException {
		
		UserFrm frm = serviceProvide.getUserService().login(userFrm);
		HttpSession session = request.getSession(true);
		session.setAttribute("LoggedInUser", frm);
		logger.info("result userform = " + frm);
		return frm;
	}
	
	@RequestMapping(value=SIGNOUT_ACTION, method=RequestMethod.GET)
	public String logout(String userId, HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if (session != null) {
			logger.info("Invalidating session");
			session.invalidate();
		}else {
			logger.error("No session found");
		}
		return AUTHENTICATE_PAGE;
	}
	
	@RequestMapping(value = FRM_USER_ACTION, method = RequestMethod.GET)
	public String addUserForm(ModelMap model) {
		UserFrm userForm=new UserFrm();
		model.addAttribute("userFrm", userForm);
		return ADD_USER_PAGE;
	}

	@RequestMapping(value = ADD_USER_ACTION, method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userFrm") @Valid UserFrm userFrm,
			BindingResult result) {
		try {
			serviceProvide.getUserService().addUser(userFrm);
		} catch (EmsException e) {
			e.printStackTrace();
		}
		return new ModelAndView(ADD_USER_PAGE);
	}


}
