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


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amaneng.ems.web.utility.EmsException;


/**
 * Common validation utility.
 * 
 * @author mraza
 * 
 */
public class ValidationUtils {

	/**
	 * This method check the empty string as well as special character in
	 * string.
	 * 
	 * @param src
	 * @return
	 * @throws SpsiException
	 */
	public static boolean isEmpty(String src) {
		return (src == null || src.trim().isEmpty() || "null".equalsIgnoreCase(src));
	}

	public static boolean isEmpty(Long src) {
		return (src == null || src.longValue() == -1L);
	}
	
	public static boolean isEmpty(Integer src) {
		return (src == null || src.intValue() == -1);
	}

	public static boolean isNull(String src) {
		return (src == null || src.trim().isEmpty());
	}

	public static boolean isNull(Integer src) {
		return (src == null);
	}
	
	public static boolean isNull(Long src) {
		return (src == null);
	}
	
	public static boolean isNull(java.util.Date src) {
		return (src == null);
	}
	

	/**
	 * negative check: leading (-) is not allowed in input
	 * @param src
	 * @return
	 * @throws SpsiException
	 */
	public static boolean isPositiveValue(String src)throws EmsException{
		if(src==null || src.startsWith("-") ){
			throw EmsException.getTSException(3057,null);
		}
		return true;
	}
	/**
	 * @param src
	 * @param maxLen
	 * @return
	 * @throws SpsiException 
	 */
	public static boolean isValidLength(String src, int maxLen) throws EmsException {
		boolean isValid=false;
		if (src != null && src.length() <= maxLen) {
			//return true;
			isValid=true;
		}
		//isPositiveValue(src);
		return isValid;
	}

	
	public static boolean isValidExactLength(String src, int maxLen) {

		if (src != null && src.length() == maxLen) {
			return true;
		}

		return false;
	}
	
	public static boolean isValidBinaryBitMask(String src, int length) {
		if (src == null || src.length() != length) {
			return false;
		}
		return src.matches("[0-1]*");
	}
	
	public static boolean isValidBitMask(String src, int length) {
		if (src == null || src.length() != length) {
			return false;
		}
		return src.matches("[0-2]*");
	}

	/*
	 * 
	 */
	public static boolean isValidOption(String src, String[] values) {
		if (src == null) {
			return false;
		}
		for (String val : values) {
			if (src.equals(val)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidOption(Integer src, int[] values) {
		if (src == null) {
			return false;
		}
		for (int val : values) {
			if (src.equals(val)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidOption(Long src, int[] values) {
		if (src == null) {
			return false;
		}
		for (long val : values) {
			if(src.equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidOption(Character src, char[] options) {
		if (src == null) {
			return false;
		}
		for (char option : options) {
			if (src.equals(option)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAlfaNumeric(String src) {
		if (src == null) {
			return false;
		}
		if (src.matches("[a-zA-z0-9]*")) {
			return true;
		}
		return false;
	}
	
	
	public static boolean isNumeric(String src) {
		return (src == null) ? false : src.matches("[0-9]*");
	}

	public static boolean isValidDate(String src, final String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		java.util.Date date = null;
		try {
			date = sdf.parse(src);
			/**
			 * dateformat.parse() will accept any date as long as it's in the
			 * format you defined, it simply rolls dates over, for example,
			 * December 32 becomes Jan 1 and December 0 becomes November 30 This
			 * statement will make sure that once the string has been checked
			 * for proper formatting that the date is still the date that was
			 * entered, if it's not, we assume that the date is invalid
			 */
			if (!sdf.format(date).equalsIgnoreCase(src)) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * @param time
	 * @return
	 */
	public static boolean isValid24HrTime(String time) {
		return (time == null) ? false : time.matches("([01][0-9]|2[0-3])[0-5][0-9]");
	}

	/**
	 * This method checks for the following special character in the given
	 * string  ? # & % * | ^ ~ , ; < > !
	 * 
	 * This method wont work with email address validation.
	 * 
	 * @param arg
	 * @return true if string has no special character
	 * @throws SpsiException
	 *              with error code 3057 in case special
	 *              character found in string
	 */
	public static boolean hasSpecialCharector(final String arg){
		final String specialCharPattern = "[,;?<>!~#$%*^&|!\\[#$]";
		Pattern patternp = Pattern.compile(specialCharPattern);
		Matcher m=patternp.matcher(arg);
		return m.find();
	}
	
	/**
	 * This method validates the IP address pattern in IPV4 format.
	 * @param ip
	 * @return
	 */
	public static boolean isValidIPAddress(final String ip){
		final String ipaddressPattern = 
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		Pattern pattern = Pattern.compile(ipaddressPattern);
		Matcher matcher = pattern.matcher(ip);
		return matcher.matches();
	}
	
}
