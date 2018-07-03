package com.example.diary2.dto.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiaryEntryResponse {

	private boolean response;
	
	private Integer status;

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
	
	
}
