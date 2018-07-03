package com.example.diary2.repository;

import java.util.List;

import com.example.diary2.model.UserFollowingInformation;
import com.example.diary2.model.UserInfo;

public interface UserFollowingInformationRepositoryCustom {

	public int getNumberOfFollowers(UserInfo followedUser);
	
	public int getNumberOfFollowing(UserInfo user);
	
	public UserFollowingInformation getUserFollowingInformationByuserAndFollowed(UserInfo user,UserInfo followedUser);
	
	public List<UserFollowingInformation> getAllFollowedUsers(UserInfo user);
}
