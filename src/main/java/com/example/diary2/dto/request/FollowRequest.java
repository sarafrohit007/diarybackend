package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FollowRequest {

	@NotNull
	private Integer trxnTypeId;
	
	@NotNull
	private String userEmailId;
	
	@NotNull
	private String toBeFollowedUserEmailId;

	public Integer getTrxnTypeId() {
		return trxnTypeId;
	}

	public void setTrxnTypeId(Integer trxnTypeId) {
		this.trxnTypeId = trxnTypeId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getToBeFollowedUserEmailId() {
		return toBeFollowedUserEmailId;
	}

	public void setToBeFollowedUserEmailId(String toBeFollowedUserEmailId) {
		this.toBeFollowedUserEmailId = toBeFollowedUserEmailId;
	}
	
	
}
