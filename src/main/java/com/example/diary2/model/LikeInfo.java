package com.example.diary2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.diary2.enums.ContentType;

@Entity
@Table(name="like_info")
public class LikeInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8006316553819702872L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo user;
	
	private Date likeTime;
	
	private Date unlikeTime;
	
	private Integer status;
	
	private ContentType contentType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DiaryEntry diaryEntry;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private CommentEntry commentEntry;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLikeTime() {
		return likeTime;
	}

	public void setLikeTime(Date likeTime) {
		this.likeTime = likeTime;
	}

	public Date getUnlikeTime() {
		return unlikeTime;
	}

	public void setUnlikeTime(Date unlikeTime) {
		this.unlikeTime = unlikeTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public DiaryEntry getDiaryEntry() {
		return diaryEntry;
	}

	public void setDiaryEntry(DiaryEntry diaryEntry) {
		this.diaryEntry = diaryEntry;
	}

	public CommentEntry getCommentEntry() {
		return commentEntry;
	}

	public void setCommentEntry(CommentEntry commentEntry) {
		this.commentEntry = commentEntry;
	}
	
			
}
