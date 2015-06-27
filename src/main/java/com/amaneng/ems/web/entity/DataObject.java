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

package com.amaneng.ems.web.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DataObject implements Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2320776625988072826L;
	
	public static int ACTIVE_MARKER = 1;
	
	@Column(name="is_active")
	private Integer isActive=ACTIVE_MARKER;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="last_upd_by")
	private String lastUpdatedBy;
	
	@Column(name="last_upd_dt")
	private Date lastUpdatedDate;

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "DataObject [isActive=" + isActive + ", createdBy=" + createdBy
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", createdDate="
				+ createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	public DataObject(){
		setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
		setLastUpdatedDate(new java.sql.Date(System.currentTimeMillis()));
	}
}
