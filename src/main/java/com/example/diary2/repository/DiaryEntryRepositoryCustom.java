package com.example.diary2.repository;

import java.util.List;

import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserInfo;
public interface DiaryEntryRepositoryCustom {

	public List<DiaryEntry> getDiaryEntryByUser(UserInfo user);
		
    public List<DiaryEntry> getDiaryEntriesRelatedtoMultipleUsers(List<UserInfo> usersList);
}
