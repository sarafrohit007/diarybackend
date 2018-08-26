package com.example.diary2.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.diary2.model.CommentEntry;
import com.example.diary2.model.CommentInfo;
import com.example.diary2.repository.CommentEntryRepositoryCustom;


public class CommentEntryRepositoryImpl implements CommentEntryRepositoryCustom{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public CommentEntry getCommentEntryById(Integer id) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(CommentEntry.class);
		criteria.add(Restrictions.eq("id",id));
		return (CommentEntry) criteria.uniqueResult();
	}

}
