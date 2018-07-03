package com.example.diary2.dto.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WebHookResponse {
	
	private String ok;
	
	private String result;
	
	private String description;

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "WebHookResponse [ok=" + ok + ", result=" + result + ", description=" + description + "]";
	}

}
