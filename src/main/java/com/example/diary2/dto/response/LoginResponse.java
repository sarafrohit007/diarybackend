package com.example.diary2.dto.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.model.DiaryEntry;

@XmlRootElement
public class LoginResponse {

	private Integer numberOfPosts;
	
	private Integer numberOfFollowers;
	
	private Integer numberOfFollowing;
	
	private String userName;
	
	private List<DiaryEntry> relatedDiaryEntries;

	public Integer getNumberOfPosts() {
		return numberOfPosts;
	}

	public void setNumberOfPosts(Integer numberOfPosts) {
		this.numberOfPosts = numberOfPosts;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
