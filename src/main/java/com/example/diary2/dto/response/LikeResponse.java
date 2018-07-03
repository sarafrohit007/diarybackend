package com.example.diary2.dto.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LikeResponse {

	private int status;
	
	private boolean result;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	
}
