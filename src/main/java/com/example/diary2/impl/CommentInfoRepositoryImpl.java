package com.example.diary2.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.diary2.model.CommentInfo;
import com.example.diary2.repository.CommentInfoRepositoryCustom;

public class CommentInfoRepositoryImpl implements CommentInfoRepositoryCustom{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public CommentInfo getCommentInfoById(Integer id) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(CommentInfo.class);
		criteria.add(Restrictions.eq("id",id));
		return (CommentInfo) criteria.uniqueResult();
	}
	
	

}
