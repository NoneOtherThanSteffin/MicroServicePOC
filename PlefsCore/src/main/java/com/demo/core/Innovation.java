package com.demo.core;

import java.io.Serializable;
import java.sql.Date;

public class Innovation implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Date dateOfInnovation;

	private String innovationEmployeeName;

	private Long innovationEmployeeId;

	private String title;

	private String comments;

	public Innovation() {

	}

	public Innovation(Date dateOfInnovation, String innovationEmployeeName,
			Long innovationEmployeeId, String title, String comments) {
		super();
		this.dateOfInnovation = dateOfInnovation;
		this.innovationEmployeeName = innovationEmployeeName;
		this.innovationEmployeeId = innovationEmployeeId;
		this.title = title;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "dateOfInnovation=" + dateOfInnovation
				+ ", innovationEmployeeName=" + innovationEmployeeName + ", innovationEmployeeId="
				+ innovationEmployeeId + ", title=" + title + ", comments=" + comments + "]";
	}

	public Date getDateOfInnovation() {
		return dateOfInnovation;
	}

	public void setDateOfInnovation(Date dateOfInnovation) {
		this.dateOfInnovation = dateOfInnovation;
	}

	public String getInnovationEmployeeName() {
		return innovationEmployeeName;
	}

	public void setInnovationEmployeeName(String innovationEmployeeName) {
		this.innovationEmployeeName = innovationEmployeeName;
	}

	public Long getInnovationEmployeeId() {
		return innovationEmployeeId;
	}

	public void setInnovationEmployeeId(Long innovationEmployeeId) {
		this.innovationEmployeeId = innovationEmployeeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
