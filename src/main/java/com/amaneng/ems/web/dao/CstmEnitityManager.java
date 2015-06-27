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

package com.amaneng.ems.web.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amaneng.ems.web.annotation.CstmLogger;
import com.amaneng.ems.web.annotation.Unique;
import com.amaneng.ems.web.entity.DataObject;
import com.amaneng.ems.web.utility.EmsException;


/**
 * @author mraza
 *
 */
@Repository("cstmEntityManager")
public class CstmEnitityManager {//extends CstmHibernateDaoSupport{

	@CstmLogger
	private Logger logger;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		Session session = null;
		// Gets the current session in use
		session = this.sessionFactory.getCurrentSession();
		if (session == null){
			logger.info("Session is null");
			session = this.sessionFactory.openSession();
		}
		return session;
	}

	private static final String	DEFAULT_FIELD_VALUE	= "";
	
	public DataObject findActiveVersion(DataObject object)
			throws EmsException {
		DataObject result = null;

		try {
			String alias = "a";
			String hql = getUniqueKeyQuery(object, alias);
			hql += " AND a.isActive = " + DataObject.ACTIVE_MARKER;

			if (logger.isDebugEnabled()) {
				logger.debug("Query is - " + hql);
			}
			//System.out.println("Query = " + hql);
			List list = createQuery(hql).list();
			if (list != null && list.size() > 0) {
				result = (DataObject) list.get(0);
			}

		//} catch (NoResultException e) {
			/*if (logger.isDebugEnabled()) {
				logger.debug("No Data Found.");
			}*/
		} catch (Exception e) {
			logger.error("Error in getting record", e);
			throw EmsException.getTSException(e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Query result - " + result);
		}

		return result;
	}
	
	public List<DataObject> findAllActiveVersion(DataObject object)
			throws EmsException {
		
		List<DataObject> result = null;
		try {
			String alias = "a";
			String hql = "SELECT a FROM " + object.getClass().getName()
								+ " AS " + alias + " WHERE ";

			String clause = getListQueryClause(object, alias);
			if (clause != null && !clause.isEmpty()) {
				hql += clause + " AND ";
			}

				hql += " a.isActive = " + DataObject.ACTIVE_MARKER;

			if (logger.isDebugEnabled()) {
				logger.debug("Query is - " + hql);
			}

			result = createQuery(hql).list();

		} catch (Exception e) {
			logger.error("Error in getting records", e);
			throw EmsException.getTSException(e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Query result - " + result);
		}

		return result;
	}

	public DataObject insert(DataObject object) throws EmsException {
		if (logger.isDebugEnabled()) {
			logger.debug("Inside insert");
		}
		try {
			if (isRecordExists(object))
				throw EmsException.getTSException(3002);
			Session session = getSession();
			session.save(object);
			//getHibernateTemplate().save(object);
			logger.info("Data inserted!");
		} catch (EmsException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("TS exception caught.");
			}
			throw e;
		} catch (Exception e) {
			logger.error("Error in getting records", e);
			throw EmsException.getTSException(e);
		}

		return object;
	}
	
	/**
	 * Update an existing Entity
	 * 
	 * @param object
	 * @return updated Entity Object
	 * @throws EmsException
	 */
	
	
	public DataObject update(DataObject object) throws EmsException {
		logger.debug("Inside update   object="+object);
		try{
			 Session session = getSession();
			 session.update(object);
		} catch (Exception e) {
			logger.error("Error in getting records", e);
			throw EmsException.getTSException(e);
		}
		return object;
	}

/*	public DataObjecQt update(DataObject object) throws EmsException {
		if (logger.isDebugEnabled()) {
			logger.debug("Inside update");
		}


		try{
			
			 Session session = getSession();
			 session.update(object);
			
		// get the old data object
		//DataObject oldObject = findLatestVersion(object);

		// if old record is null, throw exception
		//if (oldObject == null)
		//	throw EmsException.getTSException(3003);

		
			if (logger.isDebugEnabled()) {
				logger.debug("Making existing record old and creating new record");
			}
			//oldObject.setIsActive(DataObject.ACTIVE_MARKER);
			
			em.merge(oldObject);
			em.flush(); // force the SQL insert and triggers to run

			em.detach(oldObject);

			smsMerge(object, oldObject);
			oldObject.setIsActive((short)DataObject.ACTIVE_MARKER);
			updateCommonFields(oldObject);
			em.persist(oldObject);
			object = oldObject;
			em.flush(); // force the SQL insert and triggers to run

		
		}catch (EmsException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("EmsException excecption caught.");
			}
			throw e;
		} catch (Exception e) {
			//logger.error("Error in getting records", e);
			throw EmsException.getTSException(e);
		}
		
		return object;
	}
*/

	private boolean isRecordExists(DataObject object) throws EmsException {
		DataObject oldDataObject = findActiveVersion(object);
		if (oldDataObject != null)
			return true;

		try {
			String ejbQuery = getUniqueKeyQuery(object, "a")
								+ " AND a.isActive = 1";
			oldDataObject = (DataObject) createQuery(ejbQuery)
				.list();

			if (oldDataObject != null) {
				return true;
			}

		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug("No Data Found.");
			}
		}

		return false;
	}

	private DataObject findLatestVersion(DataObject object) throws EmsException {

		DataObject result = null;

		try {
			String alias = "a";
			String hql = getUniqueKeyQuery(object, alias);
			
			/*if (logger.isDebugEnabled()) {
				logger.debug("Query is - " + hql);
			}*/

			result = (DataObject) createQuery(hql).list();

		} catch (Exception e) {
			//logger.error("Error in getting record", e);
			throw EmsException.getTSException(e);
		}

		/*if (logger.isDebugEnabled()) {
			logger.debug("Query result - " + result);
		}*/

		return result;
	}

	
	private String getUniqueKeyQuery(DataObject object, String alias)
			throws EmsException {
		String kExpression = getUKClause(object, alias);
		if (kExpression == null || kExpression.isEmpty())
			kExpression = getPKClause(object, alias);

		String ejbQuery = "SELECT a FROM " + object.getClass().getName()
							+ " AS " + alias + " WHERE " + kExpression;

		return ejbQuery;
	}
	
	private String getUKClause(DataObject object, String alias)
			throws EmsException {
		StringBuffer sb = new StringBuffer();
		boolean hasMultipleIds = false;
		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Unique.class)) {
					if (hasMultipleIds)
						sb.append(" AND ");

					// add column
					sb.append(alias + "." + field.getName() + "=");

					// append value
					field.setAccessible(true);

					Object value;
					value = field.get(object);

					// Data type for unique key could be long or string
					if (value instanceof String)
						sb.append("'" + value + "'");
					else
						sb.append(String.valueOf(value));

					hasMultipleIds = true;
				}
			}
		} catch (Exception e) {
			logger.error("Error-", e);
			 throw EmsException.getTSException(e);
		}

		if (!sb.toString().trim().isEmpty())
			return sb.toString();
		else
			return null;
	}

	private String getPKClause(DataObject object, String alias)
			throws EmsException {
		StringBuffer sb = new StringBuffer();
		boolean hasMultipleIds = false;
		try {
			Method[] methods = object.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(Id.class)) {
					if (hasMultipleIds)
						sb.append(" AND ");

					String tmp = method.getName().substring(3, 4);
					tmp = tmp.toLowerCase();

					Field field = object.getClass().getDeclaredField(
						tmp + method.getName().substring(4));

					// add column
					sb.append(alias + "." + field.getName() + "=");

					// append value
					field.setAccessible(true);

					Object value;
					value = field.get(object);

					// Data type for primary key could be long or string
					if (value instanceof String)
						sb.append("'" + String.valueOf(value) + "'");
					else
						sb.append(String.valueOf(value));

					hasMultipleIds = true;
				}
			}
		} catch (Exception e) {
			//logger.error("Error-", e);
			throw EmsException.getTSException(e);
		}
		
		if (!sb.toString().trim().isEmpty())
			return sb.toString();
		else
			return null;
	}

	
	public Query createQuery(String query) {
		Session session=getSession();
		Query q = session.createQuery(query);
		return q;
	}
	
	
	private String getListQueryClause(DataObject object, String alias)
			throws EmsException {
		StringBuffer sb = new StringBuffer();
		boolean hasMultipleIds = false;
		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}

				boolean isTransient = false;

				try {
					String name = field.getName().substring(0, 1);
					name = "get" + name.toUpperCase()
							+ field.getName().substring(1);
					Method method = object.getClass().getDeclaredMethod(name, new Class[] {});
					if (method.isAnnotationPresent(Transient.class)) {
						isTransient = true;
					}
				} catch (NoSuchMethodException e) {
					//logger.error("Error-", e);
					isTransient = true;
				}

				if (isTransient) {
					continue;
				}

				field.setAccessible(true);
				Object value = field.get(object);

				if (value != null) {
					String strValue = value.toString();

					if (strValue.isEmpty() == false && !DEFAULT_FIELD_VALUE.equals(strValue)) {

						if (hasMultipleIds)
							sb.append(" AND ");

						// add column
						// sb.append(alias + "." + field.getName() + "=");
						sb.append(alias + "." + field.getName());
						
						if (strValue.contains("%")) {
							sb.append(" LIKE ");
						} else {
							sb.append(" = ");
						}

						// Data type for primary key could be long or string
						if (value instanceof String)
							sb.append("'" + value + "'");
						else
							sb.append(value);

						hasMultipleIds = true;
					}
				}
			}
		} catch (Exception e) {
			//logger.error("Error-", e);
			throw EmsException.getTSException(e);
		}

		if (!sb.toString().trim().isEmpty())
			return sb.toString();
		else
			return null;
	}
}
