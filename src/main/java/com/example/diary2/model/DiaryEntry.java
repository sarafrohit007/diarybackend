package com.example.diary2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class DiaryEntry implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6492689052913801962L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Date postTime;
	
	@NotNull
	private UserInfo user;
		
	@NotNull
	private ContentInfo content;
	
	@Column(name="likeinfolist")
	@OneToMany(targetEntity=LikeInfo.class,fetch=FetchType.LAZY)
	private Set<LikeInfo> likeInfoList;
	
	@Column(name="commentinfolist")
	@OneToMany(targetEntity=CommentInfo.class,fetch=FetchType.LAZY)
	private Set<CommentInfo> commentInfoList;
	
	private Integer shared;
	
	private Integer viewed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public ContentInfo getContent() {
		return content;
	}

	public void setContent(ContentInfo content) {
		this.content = content;
	}

	public Integer getShared() {
		return shared;
	}

	public void setShared(Integer shared) {
		this.shared = shared;
	}

	public Integer getViewed() {
		return viewed;
	}

	public void setViewed(Integer viewed) {
		this.viewed = viewed;
	}

	public Set<LikeInfo> getLikeInfoList() {
		return likeInfoList;
	}

	public void setLikeInfoList(Set<LikeInfo> likeInfoList) {
		this.likeInfoList = likeInfoList;
	}

	public Set<CommentInfo> getCommentInfoList() {
		return commentInfoList;
	}

	public void setCommentInfoList(Set<CommentInfo> commentInfoList) {
		this.commentInfoList = commentInfoList;
	}
	
	
	
	
}
