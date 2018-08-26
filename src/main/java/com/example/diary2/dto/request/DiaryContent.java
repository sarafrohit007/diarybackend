package com.example.diary2.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiaryContent {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
		
}
