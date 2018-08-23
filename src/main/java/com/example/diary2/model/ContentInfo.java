package com.example.diary2.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContentInfo implements Serializable{

	@Id
	@Column(name="content_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="content",length=20000)
	private String content;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
}
