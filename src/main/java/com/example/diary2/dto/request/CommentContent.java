package com.example.diary2.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentContent {
	
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
