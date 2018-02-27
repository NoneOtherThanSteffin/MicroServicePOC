package com.demo.rewardsinnovationservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reward implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Date dateOfReward;

	@Column(nullable = false)
	private String receivedEmployeeName;

	@Id()
	private Long receivedEmployeeId;

	@Column(nullable = false)
	private String title;

	private String rewardType;

	private String comments;

	public Reward() {

	}

	public Reward(Date dateOfReward, String receivedEmployeeName, Long receivedEmployeeId,
			String title, String rewardType, String comments) {
		this.dateOfReward = dateOfReward;
		this.receivedEmployeeName = receivedEmployeeName;
		this.receivedEmployeeId = receivedEmployeeId;
		this.title = title;
		this.rewardType = rewardType;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return " dateOfReward=" + dateOfReward
				+ ", receivedEmployeeName=" + receivedEmployeeName + ", receivedEmployeeId=" + receivedEmployeeId
				+ ", title=" + title + ", rewardType=" + rewardType + ", comments=" + comments + "]";
	}

	public Date getDateOfReward() {
		return dateOfReward;
	}

	public void setDateOfReward(Date dateOfReward) {
		this.dateOfReward = dateOfReward;
	}

	public String getReceivedEmployeeName() {
		return receivedEmployeeName;
	}

	public void setReceivedEmployeeName(String receivedEmployeeName) {
		this.receivedEmployeeName = receivedEmployeeName;
	}

	public Long getReceivedEmployeeId() {
		return receivedEmployeeId;
	}

	public void setReceivedEmployeeId(Long receivedEmployeeId) {
		this.receivedEmployeeId = receivedEmployeeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
