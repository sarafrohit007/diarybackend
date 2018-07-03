package com.example.diary2.dto.DialogFlow;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown =true)
public class Status {
	
	String code;
	String errorType;
	boolean webhookTimedOut;
	String errorDetails;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public boolean isWebhookTimedOut() {
		return webhookTimedOut;
	}
	public void setWebhookTimedOut(boolean webhookTimedOut) {
		this.webhookTimedOut = webhookTimedOut;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
