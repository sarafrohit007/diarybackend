package com.example.diary2.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="content_info")
public class ContentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5630457479678927235L;

	@Id
	@Column(name="content_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
//	@Column(name="content",length=20000)
//	private String content;
	
	@Column(name="contentInBytes")
	private byte[] contentInBytes;
	
	@Column(name="image_urls")
	@ElementCollection(targetClass=String.class)
	private Set<String> imageUrls;
	
	@Column(name="upload_status")
	private int uploadStatus;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Set<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(Set<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public int getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public byte[] getContentInBytes() {
		return contentInBytes;
	}

	public void setContentInBytes(byte[] contentInBytes) {
		this.contentInBytes = contentInBytes;
	}	
	
	
}
