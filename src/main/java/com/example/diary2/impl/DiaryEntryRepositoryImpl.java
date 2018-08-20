package com.example.diary2.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.DiaryEntryRepositoryCustom;
import com.example.diary2.util.ApplicationConstants;

@Repository
@Transactional
public class DiaryEntryRepositoryImpl implements DiaryEntryRepositoryCustom {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<DiaryEntry> getDiaryEntryByUser(UserInfo user) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.addOrder(Order.desc("postTime"));
		criteria.setMaxResults(10);
		return criteria.list();
	}

	@Override
	public List<DiaryEntry> getDiaryEntriesRelatedtoMultipleUsers(List<UserInfo> usersList) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.add(Restrictions.in("user",usersList));
		criteria.setMaxResults(ApplicationConstants.MAXIMUM_RESULT_COUNT_IN_SINGLE_SEARCH);
		criteria.addOrder(Order.desc("postTime"));
		return criteria.list();
	}

	@Override
	public List<DiaryEntry> getLatestDiaryEntry() {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.addOrder(Order.desc("postTime"));
		criteria.setFetchSize(ApplicationConstants.MAXIMUM_DEFAULT_SINGLE_SEARCH);
		return criteria.list();
	}	
	
}
