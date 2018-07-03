package com.example.diary2.repository;

import com.example.diary2.model.UserInfo;

public interface UserInfoRepositoryCustom {

	public UserInfo getUserInfoByEmailId(String emailId);
	
	public UserInfo getUserInfoById(Integer id);
}
