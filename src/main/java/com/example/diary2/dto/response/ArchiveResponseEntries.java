package com.example.diary2.dto.response;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.dto.request.ArchiveDiaryResult;
import com.example.diary2.model.DiaryEntry;

@XmlRootElement
public class ArchiveResponseEntries {

	@NotNull
	private Integer year;
	
	private List<ArchiveDiaryResult> diaryEntryList;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<ArchiveDiaryResult> getDiaryEntryList() {
		return diaryEntryList;
	}

	public void setDiaryEntryList(List<ArchiveDiaryResult> diaryEntryList) {
		this.diaryEntryList = diaryEntryList;
	}
	
	
}
