package com.example.diary2.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary2.dto.request.DiaryEntryRequest;
import com.example.diary2.dto.request.FollowRequest;
import com.example.diary2.dto.response.FollowResponse;
import com.example.diary2.model.UserFollowingInformation;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.UserFollowingInformationRepository;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.ApplicationConstants;

@Service
public class FollowService {


	@PersistenceContext
	EntityManager em;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	UserFollowingInformationRepository userFollowingInformationRepository;
	
	
	@Transactional
	public FollowResponse followRequest(FollowRequest request) {
		// TODO Auto-generated method stub
		FollowResponse followResponse = new FollowResponse();
		String[] requestEmailIdArrays = request.getToBeFollowedUserEmailId().split(",");
		UserInfo userInfo = userInfoRepository.getUserInfoByEmailId(request.getUserEmailId());
		for(String emailToBeFollowed : requestEmailIdArrays) {
			if(!emailToBeFollowed.equals("")) {
				UserInfo userToBeFollowed = userInfoRepository.getUserInfoByEmailId(emailToBeFollowed);
				if(userToBeFollowed!=null) {
					try {
						UserFollowingInformation userFollowingInformation = userFollowingInformationRepository.getUserFollowingInformationByuserAndFollowed(userInfo, userToBeFollowed);
						if(userFollowingInformation==null) {
							userFollowingInformation = createUserFollowingInfo(userInfo, userToBeFollowed);
							followResponse.setStatus(ApplicationConstants.USER_FOLLOW_STATUS);
						}else {
							if(userFollowingInformation.getStatus() == ApplicationConstants.USER_FOLLOW_STATUS) {
								userFollowingInformation = updateUserFollowingInfoObject(userFollowingInformation,ApplicationConstants.USER_UNFOLLOW_STATUS);
								followResponse.setStatus(ApplicationConstants.USER_UNFOLLOW_STATUS);
							}else {
								userFollowingInformation = updateUserFollowingInfoObject(userFollowingInformation, ApplicationConstants.USER_FOLLOW_STATUS);
								followResponse.setStatus(ApplicationConstants.USER_FOLLOW_STATUS);
							}
						}
						em.persist(userFollowingInformation);
						followResponse.setFollowReult(true);
					}catch(Exception e) {
						e.printStackTrace();
						followResponse.setFollowReult(false);
						followResponse.setStatus(ApplicationConstants.USER_FOLLOW_ERROR);
						
					}
				}else {
					followResponse.setFollowReult(false);
					followResponse.setStatus(ApplicationConstants.USER_TO_BE_FOLLOWED_NOT_ON_SYSTEM);
				}
			}
		}
		return  followResponse;
	}


	public UserFollowingInformation updateUserFollowingInfoObject(UserFollowingInformation userFollowingInformation, int userUnfollowStatus) {
		if(userUnfollowStatus == ApplicationConstants.USER_UNFOLLOW_STATUS) {
			userFollowingInformation.setStatus(ApplicationConstants.USER_UNFOLLOW_STATUS);
			userFollowingInformation.setUnFollowTime(new Date());
			userFollowingInformation.setFollowTime(null);
		}else {
			userFollowingInformation.setStatus(ApplicationConstants.USER_FOLLOW_STATUS);
			userFollowingInformation.setFollowTime(new Date());
			userFollowingInformation.setUnFollowTime(null);
		}
		return userFollowingInformation;
	}


	public UserFollowingInformation createUserFollowingInfo(UserInfo userInfo, UserInfo userToBeFollowed) {
		UserFollowingInformation userFollowingInformation;
		userFollowingInformation = new UserFollowingInformation();
	//	userFollowingInformation.setId(1);
		userFollowingInformation.setUser(userInfo);
		userFollowingInformation.setFollowedUser(userToBeFollowed);
		userFollowingInformation.setStatus(ApplicationConstants.USER_FOLLOW_STATUS);
		userFollowingInformation.setFollowTime(new Date());
		userFollowingInformation.setUnFollowTime(null);
		return userFollowingInformation;
	}


	/*public Object submitEntry(DiaryEntryRequest request) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
