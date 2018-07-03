package com.example.diary2.dto.DialogFlow;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class Metadata {
	
	String intentId;
	boolean webhookUsed;
	boolean webhookForSlotFillingUsed;
	String intentName;
	
	public String getIntentId() {
		return intentId;
	}
	public void setIntentId(String intentId) {
		this.intentId = intentId;
	}
	public boolean isWebhookUsed() {
		return webhookUsed;
	}
	public void setWebhookUsed(boolean webhookUsed) {
		this.webhookUsed = webhookUsed;
	}
	public boolean isWebhookForSlotFillingUsed() {
		return webhookForSlotFillingUsed;
	}
	public void setWebhookForSlotFillingUsed(boolean webhookForSlotFillingUsed) {
		this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
	}
	public String getIntentName() {
		return intentName;
	}
	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}
	
	

}
