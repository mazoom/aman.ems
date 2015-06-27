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



import static com.amaneng.ems.web.utility.ResourceConstant.MAIN_PAGE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author mraza
 *
 */
@Controller
//@SessionAttributes("userFrm")
public class HomeController {

	@RequestMapping({"/", "/index"})
	public String showHome(ModelMap model){
		//return "redirect:/"+MAIN_PAGE;
		//UserFrm userForm=new UserFrm();
		//model.addAttribute("userFrm", userForm);
		System.out.println("in HomeController");
		return MAIN_PAGE;
	}
}
