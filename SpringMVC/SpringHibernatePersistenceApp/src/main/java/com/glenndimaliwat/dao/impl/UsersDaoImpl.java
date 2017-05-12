package com.glenndimaliwat.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.glenndimaliwat.dao.UsersDao;
import com.glenndimaliwat.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	SessionFactory session;
	
	public void add(Users users) {
		session.getCurrentSession().save(users);
	}

	public void edit(Users users) {
		session.getCurrentSession().update(users);

	}

	public void delete(int userId) {
		session.getCurrentSession().delete(getUser(userId));

	}

	public Users getUser(int userId) {
		return (Users)session.getCurrentSession().get(Users.class, userId);
	}

	public List getAllUsers() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

}
