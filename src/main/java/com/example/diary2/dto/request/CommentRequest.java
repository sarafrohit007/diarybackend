package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.model.ContentInfo;

@XmlRootElement
public class CommentRequest {

	@NotNull
	private Integer trxnTypeId;
	
	@NotNull
	private String emailId;
	
	
	private String comment;
	
	
	
	@NotNull
	private Integer parentCommentId;
	
	@NotNull
	private ContentInfo content;

	public Integer getTrxnTypeId() {
		return trxnTypeId;
	}

	public void setTrxnTypeId(Integer trxnTypeId) {
		this.trxnTypeId = trxnTypeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	
	
}
