package com.demo.rewardsinnovationservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Innovation implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Date dateOfInnovation;

	@Column(nullable = false)
	private String innovationEmployeeName;

	@Id
	private Long innovationEmployeeId;

	@Column(nullable = false)
	private String title;

	private String comments;

	public Innovation() {

	}

	public Innovation(Date dateOfInnovation, String innovationEmployeeName, Long innovationEmployeeId, String title,
			String comments) {
		super();
		this.dateOfInnovation = dateOfInnovation;
		this.innovationEmployeeName = innovationEmployeeName;
		this.innovationEmployeeId = innovationEmployeeId;
		this.title = title;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "dateOfInnovation=" + dateOfInnovation + ", innovationEmployeeName=" + innovationEmployeeName
				+ ", innovationEmployeeId=" + innovationEmployeeId + ", title=" + title + ", comments=" + comments
				+ "]";
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
