package com.example.diary2.dto.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.model.structures.LatestContentMaxHeap;

@XmlRootElement
public class MainPageResponse {
	
	private LatestContentMaxHeap latestContentMaxHeap;

	public LatestContentMaxHeap getLatestContentMaxHeap() {
		return latestContentMaxHeap;
	}

	public void setLatestContentMaxHeap(LatestContentMaxHeap latestContentMaxHeap) {
		this.latestContentMaxHeap = latestContentMaxHeap;
	}
	
	

}
