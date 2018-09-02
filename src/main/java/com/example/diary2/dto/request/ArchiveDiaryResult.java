package com.example.diary2.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.model.ContentInfo;

@XmlRootElement
public class ArchiveDiaryResult {
	
	private String date;
	
	private ContentInfo content;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ContentInfo getContent() {
		return content;
	}

	public void setContent(ContentInfo content) {
		this.content = content;
	}
	
	

}
