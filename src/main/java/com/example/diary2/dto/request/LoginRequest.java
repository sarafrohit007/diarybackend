package com.example.diary2.dto.request;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginRequest {

	/*@NotNull
	private Integer referenceId;*/
	
	@NotNull
	private Integer trxnTypeId;
	
	@NotNull
	private String emailId;
	
	private Date loginTime;
	
	private Integer sourceIp;
	
	@NotNull
	private String userName;
	
	private String facebookToken;
	

/*	public Integer getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}*/

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

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(Integer sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFacebookToken() {
		return facebookToken;
	}

	public void setFacebookToken(String facebookToken) {
		this.facebookToken = facebookToken;
	}
	
	
}
