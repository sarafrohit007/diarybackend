package com.example.diary2.dto.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiaryEntryRequest {

	@NotNull
	private Integer trxnTypeId;
	
	@NotNull
	private String email;
	
	//private String content;
	
	@NotNull
	private Integer contentType;
	
	@NotNull
	private Integer fontType;
	
	@NotNull
	private Integer share;
	
	private DiaryContent diaryContent;
	
	//private String imageUrls;
	
	public Integer getTrxnTypeId() {
		return trxnTypeId;
	}

	public void setTrxnTypeId(Integer trxnTypeId) {
		this.trxnTypeId = trxnTypeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}*/

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public Integer getFontType() {
		return fontType;
	}

	public void setFontType(Integer fontType) {
		this.fontType = fontType;
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

	/*public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}*/
	
	
}
