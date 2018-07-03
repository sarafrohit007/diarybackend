package com.example.diary2.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WebHookRequest {
	
	private String url;

	public WebHookRequest(String webHookUrl) {
		// TODO Auto-generated constructor stub
		this.url = webHookUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
