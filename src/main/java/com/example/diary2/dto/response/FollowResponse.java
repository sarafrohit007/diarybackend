package com.example.diary2.dto.response;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FollowResponse {
	
	@NotNull
	private boolean followReult;
	
	private Integer status;

	public boolean isFollowReult() {
		return followReult;
	}

	public void setFollowReult(boolean followReult) {
		this.followReult = followReult;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
		
}
