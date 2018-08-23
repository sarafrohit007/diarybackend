package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiaryEntryRequest {

	@NotNull
	private String email;
		
	@NotNull
	private Integer share;
	
	private DiaryContent diaryContent;
	
	private Integer fileUploadId;
	
//	public Integer getTrxnTypeId() {
//		return trxnTypeId;
//	}
//
//	public void setTrxnTypeId(Integer trxnTypeId) {
//		this.trxnTypeId = trxnTypeId;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public DiaryContent getDiaryContent() {
		return diaryContent;
	}

	public void setDiaryContent(DiaryContent diaryContent) {
		this.diaryContent = diaryContent;
	}

	public Integer getFileUploadId() {
		return fileUploadId;
	}

	public void setFileUploadId(Integer fileUploadId) {
		this.fileUploadId = fileUploadId;
	}	
	
}
