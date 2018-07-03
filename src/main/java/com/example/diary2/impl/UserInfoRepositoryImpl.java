package com.example.diary2.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.UserInfoRepositoryCustom;

@Repository
@Transactional
public class UserInfoRepositoryImpl implements UserInfoRepositoryCustom{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public UserInfo getUserInfoByEmailId(String emailId) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(UserInfo.class);
		criteria.add(Restrictions.eq("emailId", emailId));
		return (UserInfo) criteria.uniqueResult();
	}

	@Override
	public UserInfo getUserInfoById(Integer id) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(UserInfo.class);
		criteria.add(Restrictions.eq("id", id));
		return (UserInfo) criteria.uniqueResult();
	}

}
