package com.example.diary2.service;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary2.dto.request.DiaryContent;
import com.example.diary2.dto.request.DiaryEntryRequest;
import com.example.diary2.dto.response.DiaryEntryResponse;
import com.example.diary2.model.ContentInfo;
import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.ApplicationConstants;

@Service
public class DiaryEntryService {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@PersistenceContext 
	EntityManager em;

	public DiaryEntryResponse submitEntry(DiaryEntryRequest request) {
		// TODO Auto-generated method stub
		String email = request.getEmail();
		DiaryEntryResponse diaryEntryResponse = new DiaryEntryResponse();
		UserInfo user = userInfoRepository.getUserInfoByEmailId(email);
		if(user!=null) {
			try {
				DiaryEntry diaryEntry = new DiaryEntry();
				diaryEntry.setPostTime(new Date());
				diaryEntry.setNumberOfLikes(ApplicationConstants.INITIAL_LIKES_COUNT);
				diaryEntry.setNumberOfComments(ApplicationConstants.INITIAL_COMMENTS_COUNT);
				diaryEntry.setUser(user);
				ContentInfo content = makeContent(request.getDiaryContent());
				diaryEntry.setContent(content);
				em.persist(content);
				em.persist(diaryEntry);
				diaryEntryResponse.setResponse(true);
				diaryEntryResponse.setStatus(ApplicationConstants.DIARY_ENTRY_SUCCESS_RESPONSE);
			}catch(Exception e) {
				e.printStackTrace();
				diaryEntryResponse.setResponse(false);
				diaryEntryResponse.setStatus(ApplicationConstants.DIARY_ENTRY_FAILURE_RESPONSE);
			}
		}else {
			diaryEntryResponse.setResponse(false);
			diaryEntryResponse.setStatus(ApplicationConstants.USER_NOT_ALLOWED_TO_WRITE_DIARY);
		}
		return diaryEntryResponse;
	}

	private ContentInfo makeContent(DiaryContent diaryContent) {
		// TODO Auto-generated method stub
		ContentInfo contentObject = new ContentInfo();
		contentObject.setContent(diaryContent.getContent());
		contentObject.setGifImageUrls(null);
		contentObject.setGifImageUrls(null);
		return contentObject;
	}

}
