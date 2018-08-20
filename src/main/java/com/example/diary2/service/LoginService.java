package com.example.diary2.service;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.diary2.dto.request.FollowRequest;
import com.example.diary2.dto.request.LoginRequest;
import com.example.diary2.dto.response.FollowResponse;
import com.example.diary2.dto.response.HomePageResponse;
import com.example.diary2.dto.response.LoginResponse;
import com.example.diary2.dto.response.MainPageResponse;
import com.example.diary2.impl.DiaryEntryRepositoryImpl;
import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserFollowingInformation;
import com.example.diary2.model.UserInfo;
import com.example.diary2.model.structures.LatestContentMaxHeap;
import com.example.diary2.repository.UserFollowingInformationRepository;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.ApplicationConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LoginService {

	public static final ObjectMapper mapper = new ObjectMapper();
	private static Logger logger = Logger.getLogger(LoginService.class);
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	Environment ev;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	UserFollowingInformationRepository userFollowingInformationRepository;
	
	@Autowired
	DiaryEntryRepositoryImpl diaryEntryRepositoryImpl;

	@Transactional
	public LoginResponse loginRequest(LoginRequest request) {
		// TODO Auto-generated method stub
		try {
			logger.info("Request : " + mapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//Facebook
		String facebookURL = ev.getProperty("spring.social.facebook.graph.api.url");
		System.out.println("Printing facebookurl "+facebookURL);
		String appId= ev.getProperty("");
		String appSecretId =  ev.getProperty("");
		
		makeFaceBookAccessTokenRequest(appId,appSecretId,request.getFacebookToken());
		
		//processFacebookVerification(request);
		LoginResponse loginResponse = new LoginResponse();
		logger.info("Inside in loginRequest() function.");
		UserInfo userInfo = userInfoRepository.getUserInfoByEmailId(request.getEmailId());
		if(userInfo!=null) {
			loginResponse.setNumberOfFollowers(userFollowingInformationRepository.getNumberOfFollowers(userInfo));
			loginResponse.setNumberOfFollowing(userFollowingInformationRepository.getNumberOfFollowing(userInfo));
			loginResponse.setNumberOfPosts(userInfo.getNumberOfPosts());
			loginResponse.setUserName(userInfo.getUserName());
			return loginResponse;
		}
		
		userInfo = new UserInfo();
		userInfo.setEmailId(request.getEmailId());
		userInfo.setUserName(request.getUserName());
		userInfo.setNumberOfFollowers(0);
		userInfo.setNumberOfFollowing(0);
		userInfo.setCreationDate(new Date());
		userInfo.setNumberOfPosts(0);
		userInfo.setUserActiveStatus(ApplicationConstants.USER_ACTIVATION_STATUS);
		em.persist(userInfo);
		
		loginResponse.setNumberOfFollowers(0);
		loginResponse.setNumberOfFollowing(0);
		loginResponse.setNumberOfPosts(0);
		loginResponse.setUserName(request.getUserName());
		return loginResponse;
	}

	private void makeFaceBookAccessTokenRequest(String appId, String appSecretId, String access_Token) {
		// TODO Auto-generated method stub
		Client client = getClientObject();
		System.out.println("Printing access token "+ access_Token);
		String bsUrl = getBaseUrl();
		
		String appId1 = ev.getProperty("spring.social.facebook.appId");
		String appSecretKey = ev.getProperty("spring.social.facebook.appSecret");
		//String accsssToken= appId1+"|"+appSecretKey;
		String fields = "name,email,picture,friends{name,email,profile_pic}";
		try {
			fields = URLEncoder.encode(fields, "UTF-8");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		bsUrl+="fields="+fields+"&access_token="+access_Token;
		System.out.println("Printing Base URL at the end  "+bsUrl);
		/*baseTarget.queryParam("fields", fields);
		baseTarget.queryParam("access_token", access_Token);*/
		
		//baseTarget.queryParam(name, values)
		String response = "";
		//MeResponse meResponse = null;
		try {
		  //  meResponse = baseTarget.request(MediaType.APPLICATION_JSON).get(MeResponse.class);
			WebTarget baseTarget = client.target(bsUrl);
			response = baseTarget.request(MediaType.APPLICATION_JSON).get(String.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Printing response "+ response);
		//System.out.println("Printing Response "+ meResponse!=null?meResponse.toString():"");
	}

	@SuppressWarnings("deprecation")
	private void processFacebookVerification(LoginRequest request) {
		// TODO Auto-generated method stub
		//String access_Token = "EAAaVVZBemVgMBAKd3EfsdnuRou5EUxrAr7ne7TJoqf8LQPJfCDZA5KTHwQoG2Q4kISSBcruZB8xuAYA4AiHV2K1l8OZBZB5DR9tZAoDjPCISSTM0KYV9K68yLZAfZBleRMXbqr6zlHXdtV6d7nejBv5bmDdzS2B2Ktc7mly0NQsCZCeoQ76zheaRKNwGuOJppQuUCoVyetKUDxAZDZD";
		
		Client client = getClientObject();
		String fields = "id,name";
		
		WebTarget baseTarget = client.target(getBaseUrl());
		String appId = ev.getProperty("spring.social.facebook.appId");
		String appSecretKey = ev.getProperty("spring.social.facebook.appSecret");
		String accsssToken= appId+"|"+appSecretKey;
		baseTarget.queryParam("input_token", "EAACEdEose0cBAEhmSU8uXGZAZC3zcRjPhXNOSmhQUJk0ZAmMl2GeCi5sgACJpFEw3a0ZAvbu7sfnlUui6yb0kRVR74FzpTw1UR3QRmDUAsPwCL7u4AzIUVCzDELMwgM7l6A4duNjyk4stqkV1a95vvOExKsW60eY20ERCBcCYuZAiOjzzWHIH6ZAIFWrTZCqdilPiW8shh4vIw1nZBRS8ZB6bNZBvOWq9Hy4YZD");
		baseTarget.queryParam("fields", accsssToken);
		String response  = baseTarget.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("Printing Response "+ response);
	}

	private Client getClientObject() {
		ClientBuilder clientBuilder = new JerseyClientBuilder();
		Client client = clientBuilder.build();
		client.property(ClientProperties.CONNECT_TIMEOUT,getConnectTimeout());
		client.property(ClientProperties.READ_TIMEOUT, getReadTimeout());
		return client;
	}

	private String getBaseUrl() {
		// TODO Auto-generated method stub
		return "https://graph.facebook.com/v3.0/me?";
	}

	private Integer getReadTimeout() {
		// TODO Auto-generated method stub
		return 15000;
	}

	private Integer getConnectTimeout() {
		// TODO Auto-generated method stub
		return 15000;
	}
	
}
