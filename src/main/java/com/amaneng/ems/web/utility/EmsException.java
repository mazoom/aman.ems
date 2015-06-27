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
public class EmsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7219721057020997055L;
	
	private String errorCode;
	
	private EmsException(String errorCode){
		this.errorCode=errorCode;
	}
	
	public static EmsException getTSException(int errorCode){
		return new EmsException(String.valueOf(errorCode));
	}

	public static EmsException getTSException(int errorCode, String [] args){
		return new EmsException(String.valueOf(errorCode));
	}

	public static EmsException getTSException(Exception e){
		return new EmsException(e.getMessage());
	}

	public String getErrorCode(){
		return this.errorCode;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
