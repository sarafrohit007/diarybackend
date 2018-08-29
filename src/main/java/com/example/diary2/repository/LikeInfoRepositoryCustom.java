package com.example.diary2.repository;

import java.util.List;

import com.example.diary2.model.ContentInfo;
import com.example.diary2.model.UserInfo;

public interface LikeInfoRepositoryCustom {
	
	public List<UserInfo> getLikedByUser(ContentInfo contentInfo);
	
}
