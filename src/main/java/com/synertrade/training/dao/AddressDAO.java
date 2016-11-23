package com.synertrade.training.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.synertrade.training.util.HibernateUtil;
import com.synertrade.training.vo.TrainingAddressVO;

public class AddressDAO {
	
	public List<TrainingAddressVO> getAddresses(int streetId) {
		List<TrainingAddressVO> addresses;
		String query = "";
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		if(streetId == -1) {
			query = "from TrainingAddressVO";
		} else {
			query = "from TrainingAddressVO WHERE STREET_ID = " + streetId;
		}
		
		
		Query q = session.createQuery(query);
		
		addresses = (List<TrainingAddressVO>) q.list();
		
		for(TrainingAddressVO addr : addresses) {
			Hibernate.initialize(addr.getStreet());
			Hibernate.initialize(addr.getStreet().getCity());
			Hibernate.initialize(addr.getStreet().getCity().getCountry());
			Hibernate.initialize(addr.getUsers());
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return addresses;
	}
}
