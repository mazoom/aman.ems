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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mraza
 *
 */
@Controller
public class DashboradController {
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(){
		return openEmployeeDashboard();
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doPost(){
		return openEmployeeDashboard();
	}
	@RequestMapping(EMPLOYEE_DASHBOARD_ACTION)
	public ModelAndView openEmployeeDashboard(){
		
		return new ModelAndView(EMPLOYEE_DASHBOARD_PAGE);
	} 

}
