package com.demo.userservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_details")
public class UserDetails implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long employeeID;

	@Column(nullable = false)
	private String employeeFirstName;

	@Column(nullable = false)
	private String employeeLastName;

	@Column(nullable = false)
	private String employeeEmail;

	@Column(nullable = false)
	private String employeePassword;

	@Column(nullable = false)
	private Boolean isAdmin;

	public UserDetails() {

	}

	public UserDetails(Long employeeID, String employeeFirstName, String employeeLastName, String employeeEmail,
			String employeePassword, Boolean isAdmin) {
		super();
		this.employeeID = employeeID;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.isAdmin = isAdmin;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeEmail() {
		return this.employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return this.employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [EmployeeID=" + this.employeeID + ", EmployeeName=" + this.employeeFirstName + ", EmployeeEmail="
				+ this.employeeEmail + ", EmployeePassword=" + this.employeePassword + ", IsAdmin=" + this.isAdmin
				+ "]";
	}

}
