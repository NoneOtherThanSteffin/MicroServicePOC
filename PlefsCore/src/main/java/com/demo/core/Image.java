package com.demo.core;

import java.io.Serializable;
import java.sql.Date;

public class Image implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long imageId;

	private String image;

	private Long uploaderEmpId;

	private Date uploadedDate;

	public Image() {

	}

	public Image(Long imageId, String image, Long uploaderEmpId, Date uploadedDate) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.uploaderEmpId = uploaderEmpId;
		this.uploadedDate = uploadedDate;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getUploaderEmpId() {
		return uploaderEmpId;
	}

	public void setUploaderEmpId(Long uploaderEmpId) {
		this.uploaderEmpId = uploaderEmpId;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	@Override
	public String toString() {
		return "Gallery [imageId=" + imageId + ", image=" + image + ", uploaderEmpId=" + uploaderEmpId
				+ ", uploadedDate=" + uploadedDate + "]";
	}

}
