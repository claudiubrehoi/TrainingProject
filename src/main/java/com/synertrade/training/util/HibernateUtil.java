/*
 * Created on Dec 6, 2004
 */
package com.synertrade.training.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory				sessionFactory;
	
	private static final ThreadLocal threadSession = new ThreadLocal();
	
	private static final ThreadLocal threadTransaction = new ThreadLocal();
	
	private static final Configuration				configuration;

	static {
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
	}

	public static Session getSession() {
		
		Session s = (Session) threadSession.get();
		
		try {
			if (s == null) {
				s = sessionFactory.openSession();
				threadSession.set(s);
			}
		} catch (HibernateException ex) {
			System.out.println(ex.getStackTrace());
		}
		
		return s;
	}
	
	public static void closeSession() {
		try {
			Session s = (Session) threadSession.get();
			threadSession.set(null);
			if (s != null && s.isOpen())
			s.close();
		} catch (HibernateException ex) {
			System.out.println(ex.getStackTrace());
		}
	}
	
	public static void beginTransaction() {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			if (tx == null) {
				tx = getSession().beginTransaction();
				threadTransaction.set(tx);
			}
		} catch (HibernateException ex) {
			System.out.println(ex.getStackTrace());
		}
		
	}
	
	public static void commitTransaction() {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			if ( tx != null && !tx.wasCommitted() && !tx.wasRolledBack() ) {
				tx.commit();
			}
			threadTransaction.set(null);
		} catch (HibernateException ex) {
			rollbackTransaction();
			System.out.println(ex.getStackTrace());
		}
	}
	
	public static void rollbackTransaction() {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			threadTransaction.set(null);
			if ( tx != null && !tx.wasCommitted() && !tx.wasRolledBack() ) {
				tx.rollback();
			}
		} catch (HibernateException ex) {
			System.out.println(ex.getStackTrace());
		} finally {
			closeSession();
		}
	}

}
