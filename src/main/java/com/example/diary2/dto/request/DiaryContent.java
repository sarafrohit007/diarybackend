package com.example.diary2.dto.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiaryContent {

	private String content;
	
	private String imageUrls;
	
	private String gifUrls;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getGifUrls() {
		return gifUrls;
	}

	public void setGifUrls(String gifUrls) {
		this.gifUrls = gifUrls;
	}
	
		
}
