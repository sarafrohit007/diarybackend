package com.example.diary2.dto.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArchiveResponse {

	List<ArchiveResponseEntries> archiveEntries;

	public List<ArchiveResponseEntries> getArchiveEntries() {
		return archiveEntries;
	}

	public void setArchiveEntries(List<ArchiveResponseEntries> archiveEntries) {
		this.archiveEntries = archiveEntries;
	} 
	
	
}
