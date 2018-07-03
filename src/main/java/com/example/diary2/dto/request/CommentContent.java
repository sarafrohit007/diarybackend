package com.example.diary2.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentContent {
	
	private String comment;
	
	private String imageUrl;
	
	private String gifImageUrls;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getGifImageUrls() {
		return gifImageUrls;
	}

	public void setGifImageUrls(String gifImageUrls) {
		this.gifImageUrls = gifImageUrls;
	}
	
}
