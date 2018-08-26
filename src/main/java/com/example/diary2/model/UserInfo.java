package com.example.diary2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2450766970684124893L;

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private Integer id;
	
	private String emailId;
	
	private String userName;
	
	private Integer numberOfFollowers;// To be removed Later
	
	private Integer numberOfFollowing;// To be removed Later
		
	private Date creationDate;
	
	//private Integer numberOfPosts; // To be removed Later
	
	private Integer userActiveStatus;
	
	private String faceBookIdToken;
	
	@OneToMany(targetEntity=DiaryEntry.class,fetch=FetchType.LAZY)
	private Set<DiaryEntry> diaryEntryList;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getNumberOfFollowers() {
		return numberOfFollowers;
	}

	public void setNumberOfFollowers(Integer numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}

	public Integer getNumberOfFollowing() {
		return numberOfFollowing;
	}

	public void setNumberOfFollowing(Integer numberOfFollowing) {
		this.numberOfFollowing = numberOfFollowing;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Integer getUserActiveStatus() {
		return userActiveStatus;
	}

	public void setUserActiveStatus(Integer userActiveStatus) {
		this.userActiveStatus = userActiveStatus;
	}

	public String getFaceBookIdToken() {
		return faceBookIdToken;
	}

	public void setFaceBookIdToken(String faceBookIdToken) {
		this.faceBookIdToken = faceBookIdToken;
	}

	public Set<DiaryEntry> getDiaryEntryList() {
		return diaryEntryList;
	}

	public void setDiaryEntryList(Set<DiaryEntry> diaryEntryList) {
		this.diaryEntryList = diaryEntryList;
	}
	
	
}
