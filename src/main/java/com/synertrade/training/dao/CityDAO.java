package com.synertrade.training.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.synertrade.training.util.HibernateUtil;
import com.synertrade.training.vo.TrainingCityVO;

public class CityDAO {

	public List<TrainingCityVO> getCities(int countryId) {
		List<TrainingCityVO> cities;
		String query = "";
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		if(countryId == -1) {
			query = "from TrainingCityVO";
		} else {
			query = "from TrainingCityVO WHERE COUNTRY_ID = " + countryId;
		}
		
		
		Query q = session.createQuery(query);
		
		cities = (List<TrainingCityVO>) q.list();
		
		for(TrainingCityVO city : cities) {
			Hibernate.initialize(city.getCountry());
			Hibernate.initialize(city.getStreets());
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return cities;
	}
}
