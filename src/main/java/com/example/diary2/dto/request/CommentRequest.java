package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.model.ContentInfo;

@XmlRootElement
public class CommentRequest {
	
	@NotNull
	private String emailId;
	
	private CommentContent commentContent;
	
	private Integer parentCommentId;
	
	private Integer fileUploadId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public CommentContent getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(CommentContent commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getFileUploadId() {
		return fileUploadId;
	}

	public void setFileUploadId(Integer fileUploadId) {
		this.fileUploadId = fileUploadId;
	}

	
	
	
}
