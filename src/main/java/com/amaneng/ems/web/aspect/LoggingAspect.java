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

package com.amaneng.ems.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.amaneng.ems.web.annotation.CstmLogger;

/**
 * @author mraza
 * 
 */
@Aspect
@Component
public class LoggingAspect {

	@CstmLogger
	private Logger logger;
	
	/**
	 * A join point is in the web layer if the method is defined in a type in
	 * the com.amaneng.ems.web.controller package or any sub-package under
	 * that.
	 */
	@Pointcut("within(com.amaneng.ems.web.controller..*)")
	public void inWebLayer() {

	}

	/**
	 * A business service is the execution of any method defined on a service
	 * interface. This definition assumes that interfaces are placed in the
	 * "service" package, and that implementation types are in sub-packages.
	 */
	@Pointcut("execution(* com.amaneng.ems.web.service.*.*(..))")
	public void inServiceLayer() {
	}
	
	/**
	 * A data access is the execution of any method defined on a service
	 * interface. This definition assumes that interfaces are placed in the
	 * "service" package, and that implementation types are in sub-packages.
	 */
	@Pointcut("within(com.amaneng.ems.web.dao.impl..*)")
	public void inDataAccessLayer() {
	}

	@Before("inWebLayer()")
	public void logBeforeWeb(JoinPoint joinPoint) {
		logger.debug("***CONTROLLER ASPECT LOGGING START***");
		logger.debug("Class Name  : "+joinPoint.getThis());
		logger.debug("Method Name : "+joinPoint.getSignature().getName());
		int i=0;
		for(Object obj: joinPoint.getArgs()){
			logger.debug("Method Args["+ i++ +"] : "+obj);	
		}
		logger.debug("***CONTROLLER ASPECT LOGGING END***\n");
	}

	@Before("inServiceLayer()")
	public void logBeforeService(JoinPoint joinPoint) {
		logger.info("***SERVICE ASPECT LOGGING START***");
		logger.info("Class Name  : "+joinPoint.getThis());
		logger.info("Method Name : "+joinPoint.getSignature().getName());
		int i=0;
		for(Object obj: joinPoint.getArgs()){
			logger.info("Method Args["+ i++ +"] : "+obj);	
		}
		logger.info("***SERVICE ASPECT LOGGING END***\n");
	}
	
	@Before("inDataAccessLayer()")
	public void logBeforeDataAccess(JoinPoint joinPoint) {
		logger.info("***DATAACCESS ASPECT LOGGING START***");
		logger.info("Class Name  : "+joinPoint.getThis());
		logger.info("Method Name : "+joinPoint.getSignature().getName());
		int i=0;
		for(Object obj: joinPoint.getArgs()){
			logger.info("Method Args["+ i++ +"] : "+obj);	
		}
		logger.info("***DATAACCESS ASPECT LOGGING END***");
	}

	/*public void logAfter(JoinPoint joinPoint) {

		logger.info("logAfter() is running!");
		logger.info("Method Name : " + joinPoint.getSignature().getName());
		logger.info("******");

	}

	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		logger.info("logAfterReturning() is running!");
		logger.info("Method Name : " + joinPoint.getSignature().getName());
		logger.info("Method returned value is : " + result);
		logger.info("******");

	}

	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		logger.info("logAfterThrowing() is running!");
		logger.info("Method Name : " + joinPoint.getSignature().getName());
		logger.info("Exception : " + error);
		logger.info("******");

	}

	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		logger.info("logAround() is running!");
		logger.info("Method Name  : "
				+ joinPoint.getSignature().getName());
		logger.info("Method  arguments : "
				+ Arrays.toString(joinPoint.getArgs()));

		logger.info("Around before is running!");
		joinPoint.proceed();
		logger.info("Around after is running!");

		logger.info("******");

	}

*/}
