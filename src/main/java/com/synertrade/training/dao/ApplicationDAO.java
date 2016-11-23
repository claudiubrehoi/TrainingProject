package com.synertrade.training.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.synertrade.training.util.HibernateUtil;
import com.synertrade.training.vo.TrainingApplicationVO;

public class ApplicationDAO {
	public List<TrainingApplicationVO> getApplications() {
		List<TrainingApplicationVO> apps;
		String query = "";
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		query = "from TrainingApplicationVO";
		
		Query q = session.createQuery(query);
		
		apps = (List<TrainingApplicationVO>) q.list();
		
		for(TrainingApplicationVO app : apps) {
			Hibernate.initialize(app.getUsers());
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return apps;
	}
}
