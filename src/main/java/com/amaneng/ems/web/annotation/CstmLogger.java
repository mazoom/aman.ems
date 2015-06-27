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

package com.amaneng.ems.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * @author mraza
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface CstmLogger {

}

/** LoggerPostProcessor => Custom Spring BeanPostProcessor **/
@Component
class LoggerPostProcessor implements BeanPostProcessor {
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {
			@SuppressWarnings("unchecked")
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);

				// Check if the field is annoted with @CstmLogger
				if (field.getAnnotation(CstmLogger.class) != null) {
					CstmLogger logAnnotation = field.getAnnotation(CstmLogger.class);
					Logger logger = LoggerFactory.getLogger(bean.getClass());
					field.set(bean, logger);
				}
			}
		});

		return bean;
	}
}
