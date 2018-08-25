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
	private  ContentInfo contentInfo;
	
	@NotNull
	private String emailId;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo user;
	
	private Date likeTime;
	
	private Date unlikeTime;
	
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public ContentInfo getContentInfo() {
		return contentInfo;
	}

	public void setContentInfo(ContentInfo contentInfo) {
		this.contentInfo = contentInfo;
	}
	
	
	
		
}
