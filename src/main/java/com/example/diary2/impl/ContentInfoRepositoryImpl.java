package com.example.diary2.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.diary2.model.ContentInfo;
import com.example.diary2.repository.ContentInfoRepositoryCustom;

public class ContentInfoRepositoryImpl implements ContentInfoRepositoryCustom{
	
	@PersistenceContext
	protected EntityManager em;

	@Override
	public ContentInfo getContentInfoById(Integer id) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(ContentInfo.class);
		criteria.add(Restrictions.eq("id",id));
		//criteria.add(Restrictions.eq("status", ApplicationConstants.CONTENT_LIKE_STATUS));
		return (ContentInfo) criteria.uniqueResult();
		
	}

}
