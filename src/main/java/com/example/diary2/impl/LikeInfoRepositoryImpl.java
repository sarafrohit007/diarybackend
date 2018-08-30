package com.example.diary2.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.diary2.model.ContentInfo;
import com.example.diary2.model.LikeInfo;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.LikeInfoRepositoryCustom;
import com.example.diary2.util.ApplicationConstants;

public class LikeInfoRepositoryImpl implements LikeInfoRepositoryCustom{
	
	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<UserInfo> getLikedByUser(ContentInfo contentInfo) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(LikeInfo.class);
		criteria.add(Restrictions.eq("contentInfo", contentInfo));
		criteria.add(Restrictions.eq("status", ApplicationConstants.CONTENT_LIKE_STATUS));
		if(criteria.list().size() == 0) {
			return null;
		}
		List<UserInfo> userInfoList = criteria.list();
		return userInfoList;
	}

}
