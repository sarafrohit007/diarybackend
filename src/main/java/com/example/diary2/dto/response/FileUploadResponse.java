package com.example.diary2.dto.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileUploadResponse {
	
	private int numberOfFilesUpload;
	
	private int totalNumberOfFiles; 
	
	private int contentUploadId;

	public int getNumberOfFilesUpload() {
		return numberOfFilesUpload;
	}

	public void setNumberOfFilesUpload(int numberOfFilesUpload) {
		this.numberOfFilesUpload = numberOfFilesUpload;
	}

	public int getTotalNumberOfFiles() {
		return totalNumberOfFiles;
	}

	public void setTotalNumberOfFiles(int totalNumberOfFiles) {
		this.totalNumberOfFiles = totalNumberOfFiles;
	}

	public int getContentUploadId() {
		return contentUploadId;
	}

	public void setContentUploadId(int contentUploadId) {
		this.contentUploadId = contentUploadId;
	}
	
}
