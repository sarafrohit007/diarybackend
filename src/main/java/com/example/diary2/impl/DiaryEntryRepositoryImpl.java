package com.example.diary2.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.diary2.model.DiaryEntry;
import com.example.diary2.model.UserInfo;
import com.example.diary2.repository.DiaryEntryRepositoryCustom;
import com.example.diary2.util.ApplicationConstants;
import com.example.diary2.util.DateUtils;

@Repository
@Transactional
public class DiaryEntryRepositoryImpl implements DiaryEntryRepositoryCustom {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<DiaryEntry> getDiaryEntryByUser(UserInfo user) {
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.addOrder(Order.desc("postTime"));
		criteria.setMaxResults(10);
		return criteria.list();
	}

	@Override
	public List<DiaryEntry> getDiaryEntriesRelatedtoMultipleUsers(List<UserInfo> usersList) {
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.add(Restrictions.in("user",usersList));
		criteria.setMaxResults(ApplicationConstants.MAXIMUM_RESULT_COUNT_IN_SINGLE_SEARCH);
		criteria.addOrder(Order.desc("postTime"));
		return criteria.list();
	}

	@Override
	public List<DiaryEntry> getLatestDiaryEntry() {
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.addOrder(Order.desc("postTime"));
		criteria.setFetchSize(ApplicationConstants.MAXIMUM_DEFAULT_SINGLE_SEARCH);
		return criteria.list();
	}

	@Override
	public DiaryEntry getDiaryEntryById(Integer id) {
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.add(Restrictions.eq("id",id));
		return (DiaryEntry) criteria.uniqueResult();
	}

	@Override
	public List<DiaryEntry> getArchieveDiaryEntriesByUser(Integer userId,Integer year) {
		Date startDate = DateUtils.getStatrtDateOfTheYear(year);
		Date endDate = DateUtils.getEndDateOfTheYear(year);
		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		criteria.add(Restrictions.ge("postTime",startDate));
		criteria.add(Restrictions.le("postTime",endDate));
		criteria.add(Restrictions.eq("user.id", userId));
		/*String hql = "from DiaryEntry d1 join (select year(postTime) as year from DiaryEntry group by year) as d2 where d2.year=:year and d1.user.id=:id";
		Query query = em.unwrap(Session.class).createQuery(hql);
		query.setParameter("id",userId);
		query.setParameter("year", year);*/
		//Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
		//SQLQuery query = null;
		//query.setParameter("", user);
//		Criteria criteria = em.unwrap(Session.class).createCriteria(DiaryEntry.class);
//		criteria.add(Restrictions.eq("user", user));
//		ProjectionList projectionList = Projections.projectionList();
//		projectionList.add(Projections.sqlProjection(sql, columnAliases, types))
		//return query.list();
		//String sql = "select * from diary_entry d1 join (select year(post_time) as year from diary_entry group by year) as d2 where d2.year=:year and d1.user_id=1;";
		//SQLQuery query = (SQLQuery) em.unwrap(Session.class).createQuery(sql);
		
		return criteria.list();
	}	
	
}
