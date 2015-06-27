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

package com.amaneng.ems.web.form;



/**
 * @author mraza
 *
 */
public class UserFrm {
	
	//@NotEmpty(message="Username is mandatory.")
	//@Length(min=3,max=25,message="Username must be between 3 and 25 characters length")
	private String userId;

	//@NotEmpty(message="Password field is mandatory.")
	//@Length(min=3,max=25,message="Password must be between 5 and 25 characters length")
	private String password;
	private String password2;
	private String firstName;
	private String lastName;
	private String email;
	private String action;
	private String userType;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserFrm [userId=" + userId + ", password=" + password
				+ ", password2=" + password2 + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", action="
				+ action + "]";
	}
	
}
