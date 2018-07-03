package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HomePageRequest {
	
	@NotNull
	private Integer trxnTypeId;

	@NotNull
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public Integer getTrxnTypeId() {
		return trxnTypeId;
	}

	public void setTrxnTypeId(Integer trxnTypeId) {
		this.trxnTypeId = trxnTypeId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
