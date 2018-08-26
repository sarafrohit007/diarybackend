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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comment_entry")
public class CommentEntry implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7888771130221630934L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@OneToOne(fetch=FetchType.LAZY)
	private UserInfo user;
	
	private Date postTime;
	
	@NotNull
	@OneToOne(fetch=FetchType.LAZY)
	private CommentInfo commentInfo;
	
	@Column(name="likeinfolist")
	@OneToMany(fetch=FetchType.LAZY,targetEntity=LikeInfo.class)
	private Set<LikeInfo> likeInfoList;
	
	@Column(name="commentList")
	@OneToMany(fetch=FetchType.LAZY,targetEntity=CommentEntry.class)
	private Set<CommentEntry> commentReplies;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public CommentInfo getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(CommentInfo commentInfo) {
		this.commentInfo = commentInfo;
	}

	public Set<LikeInfo> getLikeInfoList() {
		return likeInfoList;
	}

	public void setLikeInfoList(Set<LikeInfo> likeInfoList) {
		this.likeInfoList = likeInfoList;
	}

	public Set<CommentEntry> getCommentReplies() {
		return commentReplies;
	}

	public void setCommentReplies(Set<CommentEntry> commentReplies) {
		this.commentReplies = commentReplies;
	}

}
