package com.synertrade.training.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.synertrade.training.util.HibernateUtil;
import com.synertrade.training.vo.TrainingCountryVO;
import com.synertrade.training.vo.TrainingStreetVO;

public class CountryDAO {
	
	public List<TrainingCountryVO> getCountries() {
		List<TrainingCountryVO> countries;
		String query = "";
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		query = "from TrainingCountryVO";
		
		Query q = session.createQuery(query);
		
		countries = (List<TrainingCountryVO>) q.list();
		
		for(TrainingCountryVO country : countries) {
			Hibernate.initialize(country.getCities());
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return countries;
	}
}
