package com.example.diary2.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.UserFollowingInformation;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.UserFollowingInformationRepositoryCustom;

@Transactional
@Repository
public class UserFollowingInformationRepositoryImpl implements UserFollowingInformationRepositoryCustom{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public int getNumberOfFollowers(UserInfo followedUser) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(UserFollowingInformation.class);
		criteria.add(Restrictions.eq("followedUser", followedUser));
		return criteria.list().size();
	}

	@Override
	public int getNumberOfFollowing(UserInfo user) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(UserFollowingInformation.class);
		criteria.add(Restrictions.eq("user", user));
		return criteria.list().size();
	}

	@Override
	public UserFollowingInformation getUserFollowingInformationByuserAndFollowed(UserInfo user, UserInfo followedUser) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(UserFollowingInformation.class);
		criteria.add(Restrictions.eq("user.id",user.getId()));
		criteria.add(Restrictions.eq("followedUser.id",followedUser.getId()));
		return (UserFollowingInformation)criteria.uniqueResult();
	}

	@Override
	public List<UserFollowingInformation> getAllFollowedUsers(UserInfo user) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(UserFollowingInformation.class);
		criteria.add(Restrictions.eq("user",user));
		return criteria.list();
	}
}
