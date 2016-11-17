package com.synertrade.training.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import com.synertrade.training.dto.UserDTO;
import com.synertrade.training.dto.UserTestDTO;
import com.synertrade.training.util.HibernateUtil;
import com.synertrade.training.vo.TrainingAddressVO;
import com.synertrade.training.vo.TrainingApplicationVO;
import com.synertrade.training.vo.UserVO;

public class UserDAO {


	public List<UserDTO> getUserList() {
		List<UserDTO> users;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		String query = "select new com.synertrade.training.dto.UserDTO(usr.id, usr.username, usr.name, usr.birth_date, usr.address, usr.application) from UserVO usr";
		
		Query q = session.createQuery(query);
		
		users = (List<UserDTO>) q.list();

		for (UserDTO usr : users) {
		    Hibernate.initialize(usr.getAddress());
		    Hibernate.initialize(usr.getApplication());
		    Hibernate.initialize(usr.getAddress().getStreet());
		    Hibernate.initialize(usr.getAddress().getStreet().getCity());
		    Hibernate.initialize(usr.getAddress().getStreet().getCity().getCountry());
		}
		
		tx.commit();
		HibernateUtil.closeSession();

		return users;
	}
	
	public List<UserTestDTO> getUserListNativeSQL() {
		List<UserTestDTO> users;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		String query = "select usr.ID as id, usr.USERNAME as username, usr.NAME as name, usr.BIRTH_DATE as date from TRAINING_USER usr";
		
		Query q = session.createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(com.synertrade.training.dto.UserTestDTO.class));
		
		users = (List<UserTestDTO>) q.list();

		tx.commit();
		HibernateUtil.closeSession();

		return users;
	}

	public boolean saveUser(UserVO newUser) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		if(newUser.getAddress() == null) {
			newUser.setAddress((TrainingAddressVO) session.load(TrainingAddressVO.class, 1));
		}
		
		if(newUser.getApplication() == null) {
			newUser.setApplication((TrainingApplicationVO) session.load(TrainingApplicationVO.class, 1));
		}
		
		if(newUser.getBirth_date() == null) {
			newUser.setBirth_date(new java.sql.Date(new Date().getTime()));
		}
		
		session.save(newUser);
		
		tx.commit();
		HibernateUtil.closeSession();
		return true;
	}

	public UserVO getUser(int userId) {
		
		UserVO user = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from UserVO u where u.id=" + userId);
		
		List<UserVO> usr = (List<UserVO>) query.list();
		
		if(usr.size() == 1) {
			user = usr.get(0);
		}
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return user;
		
	}
	
public UserVO getUserNativeSQL(int userId) {
		
		UserVO user = null;
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select usr.ID as id, usr.USERNAME as username, usr.NAME as NAME, usr.BIRTH_DATE as birth_date, "
														+ "{address.*} as 'address', {application.*} as 'application' "
											+ "from TRAINING_USER usr, TRAINING_ADDRESS address, TRAINING_APPLICATION application "
											+ "where usr.APPLICATION_ID = application.ID AND usr.ADDRESS_ID = address.ID AND usr.ID = " + userId)
				.addEntity("usr", com.synertrade.training.vo.UserVO.class)
				.addEntity(com.synertrade.training.vo.TrainingAddressVO.class)
				.addEntity(com.synertrade.training.vo.TrainingApplicationVO.class);
//				.addSynchronizedEntityClass(com.synertrade.training.vo.TrainingAddressVO.class)
//				.addSynchronizedEntityClass(com.synertrade.training.vo.TrainingApplicationVO.class);
//				.addJoin("addr" , "usr.address")
//				.addJoin("app", "usr.application");
		
//		query.addScalar("id", new LongType()).addScalar("username", new StringType()).addScalar("name", new StringType()).addScalar("date", new DateType());
		
		List<UserVO> usr = (List<UserVO>) query.list();
		
		if(usr.size() == 1) {
			user = usr.get(0);
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		
		return user;
		
	}

	public boolean updateUser(UserVO user) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(user);
		
		tx.commit();
		HibernateUtil.closeSession();
		
		return true;
	}

}
