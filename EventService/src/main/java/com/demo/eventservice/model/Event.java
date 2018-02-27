package com.demo.eventservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Long employeeID;

	@Column(nullable = false)
	private String eventName;

	@Id
	private Date eventDate;

	public Event(){
		
	}
	
	public Event(Long employeeID, String eventName, Date eventDate) {
		this.employeeID = employeeID;
		this.eventName = eventName;
		this.eventDate = eventDate;
	}


	public Long getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	@Override
	public String toString() {
		return "Event [employeeID=" + employeeID + ", eventName=" + eventName + ", eventDate=" + eventDate + "]";
	}
	

}
