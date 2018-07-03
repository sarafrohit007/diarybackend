/*package com.example.diary2.service;

import javax.ws.rs.core.MediaType;

import org.telegram.telegrambots.ApiContextInitializer;

import com.example.diary2.dto.request.WebHookRequest;
import com.example.diary2.dto.response.WebHookResponse;
import com.example.diary2.util.BotConstants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class WebHookService {

	public void setWebHookForApp() {
		// TODO Auto-generated method stub
		ApiContextInitializer.init();
		Builder builder = getRequestBuilder(BotConstants.WEBHOOK_RESOURCE_END_POINT);
		WebHookRequest webHookRequest = new WebHookRequest(getWebHookUrl());
		
		//WebHookResponse response =null;
		
		WebHookResponse response = null;
		
		response = builder.type("application/json").post(WebHookResponse.class,webHookRequest);
		if(response!=null) {
			System.out.println("Response Printed "+ response.toString());
		}
	}

	private String getWebHookUrl() {
		// TODO Auto-generated method stub
		return "https://6ec405a9.ngrok.io/api/telegramcert";
	}

	private Builder getRequestBuilder(String endPoint) {
		// TODO Auto-generated method stub
		String baseUrl = getBaseUrl();
		Integer readTimeout = getReadTimeout();
		Integer connectTimeout = getConnectTimeout();
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		client.setReadTimeout(readTimeout != null ? readTimeout : 22000);
		client.setConnectTimeout(connectTimeout != null ? connectTimeout : 10000);
		WebResource service = client.resource(baseUrl + "/" + endPoint);
		return service.accept(MediaType.APPLICATION_JSON);
	}

	private Integer getConnectTimeout() {
		// TODO Auto-generated method stub
		return 10000;
	}

	private String getBaseUrl() {
		// TODO Auto-generated method stub
		//535252399:AAF0gnQD0XmpcVBcPSf7gCb_u4pnjDSfT1U
		return "https://api.telegram.org/bot555041027:AAEQ3ltQc7GgGPOf-kcqRTuqA7qSnMuIZVk";
	}

	private Integer getReadTimeout() {
		// TODO Auto-generated method stub
		return 10000;
	}
	
	
}
*/