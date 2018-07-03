package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LikeRequest {
	
	@NotNull
	private Integer trxnTypeId;

	@NotNull
	private String emailId;
	
	@NotNull
	private  String contentId;
	
	@NotNull
	private Integer contentType;
	

	public Integer getTrxnTypeId() {
		return trxnTypeId;
	}

	public void setTrxnTypeId(Integer trxnTypeId) {
		this.trxnTypeId = trxnTypeId;
	}

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

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	
	
	
	
}
