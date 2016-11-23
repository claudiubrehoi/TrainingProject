package com.synertrade.training.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.synertrade.training.util.HibernateUtil;
import com.synertrade.training.vo.TrainingStreetVO;

public class StreetDAO {
	public List<TrainingStreetVO> getStreets(int cityId) {
		
		List<TrainingStreetVO> streets;
		String query = "";
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		if(cityId == -1) {
			query = "from TrainingStreetVO";
		} else {
			query = "from TrainingStreetVO WHERE CITY_ID = " + cityId;
		}
		
		
		Query q = session.createQuery(query);
		
		streets = (List<TrainingStreetVO>) q.list();
		
		for(TrainingStreetVO street : streets) {
			Hibernate.initialize(street.getCity());
			Hibernate.initialize(street.getCity().getCountry());
			Hibernate.initialize(street.getAddresses());
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return streets;
	}
}
