package com.example.diary2.dto.response;

import java.util.Date;

public class DiaryContentResponse {

	private String userEmailId;
	
	private Date postedtime; 
	
	private String timeInString;
	
	private Integer numberOfLikes;
	
	private Integer numberOfComments;

	public Integer getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(Integer numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public Integer getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(Integer numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public Date getPostedtime() {
		return postedtime;
	}

	public void setPostedtime(Date postedtime) {
		this.postedtime = postedtime;
	}

	public String getTimeInString() {
		return timeInString;
	}

	public void setTimeInString(String timeInString) {
		this.timeInString = timeInString;
	}
	
	
}
