package com.example.diary2.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary2.dto.request.HomePageRequest;
import com.example.diary2.dto.response.HomePageResponse;
import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserFollowingInformation;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.DiaryEntryRepository;
import com.example.diary2.repository.UserFollowingInformationRepository;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.ApplicationConstants;


@Service
public class HomePageService {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	DiaryEntryRepository diaryEntryRepository;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	UserFollowingInformationRepository userFollowingInformationrepository;

	public HomePageResponse getHomeComment(HomePageRequest request) {
		// TODO Auto-generated method stub
		HomePageResponse homePageResponse = new HomePageResponse();
		List<DiaryEntry> diaryEntryList = new ArrayList<DiaryEntry>();
		List<UserFollowingInformation> userFollowingInformation = new ArrayList<UserFollowingInformation>();
		List<UserInfo> userFollowed = new ArrayList<UserInfo>();
		UserInfo user = userInfoRepository.getUserInfoByEmailId(request.getEmailId());
		try {
			if(user!=null) {
				userFollowingInformation = userFollowingInformationrepository.getAllFollowedUsers(user);
				userFollowed =  getFolowedUser(userFollowingInformation);
				diaryEntryList = diaryEntryRepository.getDiaryEntriesRelatedtoMultipleUsers(userFollowed);
				homePageResponse = generateHomePageResponse(homePageResponse, diaryEntryList);
			}else {
				homePageResponse.setDiaryList(null);
				homePageResponse.setResult(true);
				homePageResponse.setStatus(ApplicationConstants.HOME_PAGE_SUCCESS_WITH_INVALID_USER);
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePageResponse.setDiaryList(null);
			homePageResponse.setResult(false);
			homePageResponse.setStatus(ApplicationConstants.HOME_PAGE_FAILURE_RESPONSE);
		}
		return homePageResponse;
	}

	public HomePageResponse generateHomePageResponse(HomePageResponse homePageResponse, List<DiaryEntry> diaryEntryList) {
		homePageResponse.setResult(true);
		homePageResponse.setDiaryList(diaryEntryList);
		if(diaryEntryList!=null && diaryEntryList.size()>0) {
			homePageResponse.setStatus(ApplicationConstants.HOME_PAGE_SUCCESS_RESPONSE);
		}else {
			homePageResponse.setStatus(ApplicationConstants.HOME_PAGE_SUCEES_WITH_ZERO_RESULT);
		}
		return homePageResponse;
	}

	private List<UserInfo> getFolowedUser(List<UserFollowingInformation> userFollowingInformationList) {
		// TODO Auto-generated method stub
		
		List<UserInfo> userFollowed = new ArrayList<UserInfo>();
		for(UserFollowingInformation userFollowingInformation : userFollowingInformationList) {
			userFollowed.add(userFollowingInformation.getFollowedUser());
		}
		return userFollowed;
	}
	
	
}
