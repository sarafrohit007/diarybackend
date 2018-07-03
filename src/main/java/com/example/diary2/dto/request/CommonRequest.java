package com.example.diary2.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.example.diary2.dto.DialogFlow.Parameters;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true )
public class CommonRequest {

	  private String actionName;

	  private Integer actionTypeId;

	  private String requesterCell;

	  private boolean globalAccess;

	  private Parameters parameters;

	  private Integer chatSource;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Integer getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(Integer actionTypeId) {
		this.actionTypeId = actionTypeId;
	}

	public String getRequesterCell() {
		return requesterCell;
	}

	public void setRequesterCell(String requesterCell) {
		this.requesterCell = requesterCell;
	}

	public boolean isGlobalAccess() {
		return globalAccess;
	}

	public void setGlobalAccess(boolean globalAccess) {
		this.globalAccess = globalAccess;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public Integer getChatSource() {
		return chatSource;
	}

	public void setChatSource(Integer chatSource) {
		this.chatSource = chatSource;
	}
	  
	  
}
