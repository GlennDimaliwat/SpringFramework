package com.glenndimaliwat.dao;

import java.util.List;

import com.glenndimaliwat.model.Users;

public interface UsersDao {
	public void add(Users users);
	public void edit(Users users);
	public void delete(int userId);
	public Users getUser(int userId);
	public List getAllUsers();
}
