package com.example.diary2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CommentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private UserInfo postedBy;
	
	@NotNull
	private  DiaryEntry diaryEntry;
	
	private Date postTime;
	
	private Integer likeCount;
	
	private Integer commentType;
	
	private CommentInfo parentComment;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(UserInfo postedBy) {
		this.postedBy = postedBy;
	}

	public DiaryEntry getDiaryEntry() {
		return diaryEntry;
	}

	public void setDiaryEntry(DiaryEntry diaryEntry) {
		this.diaryEntry = diaryEntry;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getCommentType() {
		return commentType;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	public CommentInfo getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentInfo parentComment) {
		this.parentComment = parentComment;
	}
	
	
	
}
