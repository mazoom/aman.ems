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

package com.amaneng.ems.web.utility;

/**
 * @author mraza
 * 
 */
public interface ResourceConstant {

	/*****************************************************************************************/
	/**								PAGE NAME CONSTANTS										**/
	/*****************************************************************************************/
	String AUTHENTICATE_PAGE = "Auth";
	String EMPLOYEE_DASHBOARD_PAGE = "EmployeeHome";
	String MAIN_PAGE = "Main";
	
	//User Pages
	String ADD_USER_PAGE="AddUser";
	
	
	
	/*****************************************************************************************/
	/**								ACTION CONSTANTS										**/
	/*****************************************************************************************/
	
	String EMPLOYEE_DASHBOARD_ACTION="/MyPorfile";
	
	String FRM_SIGNINF_ACTION="/SigninFrm";
	String FRM_MAIN_ACTION="/SigninFrm";
	String SIGNIN_ACTION="/Signin";
	String SIGNOUT_ACTION="/Signout";
	
	String EMPLOYEE_SIGNIN_ACTION="/EmployeeSignin";
	
	String FRM_USER_ACTION="/AddUserFrm";
	String ADD_USER_ACTION="/AddUser";
	
	
	
}
