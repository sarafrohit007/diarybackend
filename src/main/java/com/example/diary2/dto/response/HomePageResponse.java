package com.example.diary2.dto.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.dto.request.DiaryContent;
import com.example.diary2.model.DiaryEntry;

@XmlRootElement
public class HomePageResponse {

	private List<DiaryContentResponse> diaryList1;
	
	private boolean result;
	
	private Integer status;
	
	private List<DiaryEntry> diaryList;
	
	public void setDiaryList(List<DiaryEntry> diaryList) {
		this.diaryList = diaryList;
	}

	public List<DiaryEntry> getDiaryList() {
		return diaryList;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
	
	
}
