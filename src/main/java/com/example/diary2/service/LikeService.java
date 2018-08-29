package com.example.diary2.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary2.dto.request.LikeRequest;
import com.example.diary2.dto.response.LikeResponse;
import com.example.diary2.enums.ContentType;
import com.example.diary2.model.CommentEntry;
import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.LikeInfo;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.CommentEntryRepository;
import com.example.diary2.repository.DiaryEntryRepository;
import com.example.diary2.repository.UserInfoRepository;
import com.example.diary2.util.ApplicationConstants;

@Service
public class LikeService {
	
	@PersistenceContext 
	EntityManager em;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	DiaryEntryRepository diaryEntryRepository;
	
	@Autowired
	CommentEntryRepository commentEntryRepository;

	@Transactional
	public LikeResponse likeContent(LikeRequest request) {
		// TODO Auto-generated method stub
		LikeResponse likeResponse = new LikeResponse();
		try { 
			String email = request.getEmailId();
			UserInfo user = userInfoRepository.getUserInfoByEmailId(email);
			if(user!=null) {
				LikeInfo likeInfo = new LikeInfo();
				if(request.getContentType().equals(ContentType.CONTENT)) {
					DiaryEntry diaryEntry = diaryEntryRepository.getDiaryEntryById(request.getContentId()!=null?Integer.parseInt(request.getContentId()):null);
					if(diaryEntry!=null) {	
						likeInfo.setStatus(request.getLikeStatus());
						likeInfo.setDiaryEntry(diaryEntry);
						likeInfo.setCommentEntry(null);
						likeInfo.setUser(user);
						likeInfo.setContentType(ContentType.CONTENT);
					}
				}else if(request.getContentType().equals(ContentType.COMMENT)) {
					CommentEntry commentEntry = commentEntryRepository.getCommentEntryById(request.getContentId()!=null?Integer.parseInt(request.getContentId()):null);
					if(commentEntry!=null) {
						likeInfo.setStatus(request.getLikeStatus());
						likeInfo.setDiaryEntry(null);
						likeInfo.setCommentEntry(commentEntry);
						likeInfo.setUser(user);
						likeInfo.setContentType(ContentType.COMMENT);
					}
				}
				if(request.getLikeStatus() == ApplicationConstants.LIKE_STATUS_IN_LIKE_REQUEST) {
					likeInfo.setLikeTime(new Date());
					likeInfo.setUnlikeTime(null);
				}else if(request.getLikeStatus() == ApplicationConstants.UNLIKE_STATUS_IN_LIKE_REQUEST){
					likeInfo.setUnlikeTime(new Date());
					likeInfo.setLikeTime(null);
				}
				em.persist(likeInfo);
				likeResponse.setStatus(ApplicationConstants.LIKE_REQUEST_SUCCESS_STATUS);
				likeResponse.setResult(true);
			}else {
				likeResponse.setStatus(ApplicationConstants.LIKE_REQUEST_FAILURE_STATUS);
				likeResponse.setResult(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			likeResponse.setResult(false);
			likeResponse.setStatus(ApplicationConstants.LIKE_REQUEST_FAILURE_STATUS);
			//likeResponse = null;
		}
		return likeResponse;
	}
	
	

}
