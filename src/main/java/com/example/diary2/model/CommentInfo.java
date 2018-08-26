package com.example.diary2.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment_info")
public class CommentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 39529326084378470L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/*private CommentInfo parentComment;*/
	
	@Column(name="commentinbytes")
	private byte[] commentInBytes;
	
	@Column(name="image_urls")
	@ElementCollection(targetClass=String.class)
	private Set<String> imageurls;
	
/*	@Enumerated(EnumType.STRING)
	@Column(name="contenttype",nullable=false)
	private ContentType contentType;*/
	
	@Column(name="upload_status")
	private int uploadStatus;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public CommentInfo getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentInfo parentComment) {
		this.parentComment = parentComment;
	}*/

	public byte[] getCommentInBytes() {
		return commentInBytes;
	}

	public void setCommentInBytes(byte[] commentInBytes) {
		this.commentInBytes = commentInBytes;
	}

	public Set<String> getImageurls() {
		return imageurls;
	}

	public void setImageurls(Set<String> imageurls) {
		this.imageurls = imageurls;
	}

	/*public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}*/

	public int getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
	
	
}
