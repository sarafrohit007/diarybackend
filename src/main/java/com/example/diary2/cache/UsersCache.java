package com.example.diary2.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.diary2.dto.response.MainPageResponse;
import com.example.diary2.impl.DiaryEntryRepositoryImpl;
import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.structures.LatestContentMaxHeap;
import com.example.diary2.util.ApplicationConstants;

@Component
public class UsersCache {
	
	@Autowired
	DiaryEntryRepositoryImpl diaryEntryRepositoryImpl;

}
