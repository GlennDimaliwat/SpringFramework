package com.hibernate.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoginDAO {

	public boolean isLoginCorrect(String strUsername, String strPassword) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select a.username, a.password from Users a where a.username = :user and a.password =:pass");
		query.setParameter("user", strUsername);
		query.setParameter("pass", strPassword);
		
		if(!query.getResultList().isEmpty()) {
			session.close();
			return true;
		}
		
		session.close();
		return false;
	}
}
