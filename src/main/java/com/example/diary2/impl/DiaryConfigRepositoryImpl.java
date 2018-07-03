package com.example.diary2.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.diary2.model.DiaryConfig;
import com.example.diary2.repository.DiaryConfigRepositoryCustom;


public class DiaryConfigRepositoryImpl implements DiaryConfigRepositoryCustom{
	
	@PersistenceContext
	protected EntityManager em;

	@Override
	public DiaryConfig getDiaryConfigById(Integer id) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryConfig.class);
		criteria.add(Restrictions.eq("id", id));
		return (DiaryConfig) criteria.uniqueResult();
	}

}
