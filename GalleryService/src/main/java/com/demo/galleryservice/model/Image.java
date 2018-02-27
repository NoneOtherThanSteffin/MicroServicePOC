package com.demo.galleryservice.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "GALLERY")
public class Image implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long imageId;

	@Lob
	@Column(name = "imageContent", nullable = false)
	private String image;

	@Column(nullable = false)
	private Long uploaderEmpId;

	@Column(nullable = false)
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
