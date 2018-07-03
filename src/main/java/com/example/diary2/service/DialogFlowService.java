package com.example.diary2.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientProperties;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Update;


import com.example.diary2.dto.DialogFlow.DialogFlowResponse;
import com.example.diary2.dto.request.ChatRequest;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class DialogFlowService {
	
	private static int connectionTimeOutInMilliSec = 10000;
	
	private static ObjectMapper mapper = new ObjectMapper();

	public DialogFlowResponse postRequestToDialogFlow(ChatRequest request) {

		DialogFlowResponse response = null;
		try {
			WebTarget baseTarget;
			Client client = ClientBuilder.newClient();
			client.property(ClientProperties.CONNECT_TIMEOUT, connectionTimeOutInMilliSec);
			client.property(ClientProperties.READ_TIMEOUT, connectionTimeOutInMilliSec);
			String userCredentials = "Bearer " + "6a47adec5bfd42b3b1370c9174ee3151";
			baseTarget = client.target("https://api.dialogflow.com/v1/query");
			for (Entry<String, String> entry : request.getQueryParam().entrySet()) {
				//logger.info("query param:"+entry.getKey()+"\t Value: "+entry.getValue());
				System.out.println("Parameters Values "+ entry.getKey()+ " "+entry.getValue());
				baseTarget = baseTarget.queryParam(entry.getKey(), entry.getValue());
			}

			Response res = baseTarget.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, userCredentials)
					.get();
			
			String resString = res.readEntity(String.class);

			//logger.info("Response :" + resString.toString());

			response = mapper.readValue(resString, DialogFlowResponse.class);

			//logger.info("DialogFlowResponse Response Ob:" + mapper.writeValueAsString(response));
			
			System.out.println("Printing dialogflow response "+ response.getResult().getFulfillment().getSpeech());

			System.out.println("Printing response "+res.toString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public DialogFlowResponse processDialogFlowIntegration(Update update) {
		// TODO Auto-generated method stub
		
			String version = "20170712";
			
			ChatRequest chatRequest = new ChatRequest();
	        chatRequest.setSessionId(update.getMessage().getChatId().toString());
	        chatRequest.setChatId(update.getMessage().getChatId().toString());
	        chatRequest.setQueryText(update.getMessage().getText());
	        
	        Map<String, String> queryParams = new HashMap<String, String>();
			queryParams.put("v", version);
			queryParams.put("lang", "en");
			queryParams.put("sessionId",chatRequest.getSessionId());
			queryParams.put("query", chatRequest.getQueryText());
			chatRequest.setQueryParam(queryParams);
			
			DialogFlowResponse res = postRequestToDialogFlow(chatRequest);
			
			return res;
	        
	}
}
