package com.glenndimaliwat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glenndimaliwat.service.UsersService;
import com.glenndimaliwat.dao.UsersDao;
import com.glenndimaliwat.model.Users;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;
	
	@Transactional
	public void add(Users users) {
		usersDao.add(users);
	}

	@Transactional
	public void edit(Users users) {
		usersDao.edit(users);
	}

	@Transactional
	public void delete(int userId) {
		usersDao.delete(userId);
	}

	@Transactional
	public Users getUser(int userId) {
		return usersDao.getUser(userId);
	}

	@Transactional
	public List getAllUsers() {
		return usersDao.getAllUsers();
	}

}
