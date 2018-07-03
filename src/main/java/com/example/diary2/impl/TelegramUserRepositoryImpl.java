package com.example.diary2.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.TelegramUser;
import com.example.diary2.repository.TelegramUserRepositoryCustom;

@Repository
@Transactional
public class TelegramUserRepositoryImpl implements TelegramUserRepositoryCustom{

	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public TelegramUser getTelegramUserByNumber(Long chatId) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(TelegramUser.class);
		criteria.add(Restrictions.eq("chatId", chatId));
		return (TelegramUser) criteria.uniqueResult();
	}


	@Override
	public TelegramUser getTelegramUserByChatId(Long chatId) {
		// TODO Auto-generated method stub
		Criteria criteria = em.unwrap(Session.class).createCriteria(TelegramUser.class);
		criteria.add(Restrictions.eq("chatId", chatId));
		return (TelegramUser) criteria.uniqueResult();
	}

}
