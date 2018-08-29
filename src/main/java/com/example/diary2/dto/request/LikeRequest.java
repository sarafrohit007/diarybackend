package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.enums.ContentType;

@XmlRootElement
public class LikeRequest {

	@NotNull
	private String emailId;
	
	@NotNull
	private  String contentId;
	
	private ContentType contentType;
	
	private Integer likeStatus;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public Integer getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(Integer likeStatus) {
		this.likeStatus = likeStatus;
	}	

}
