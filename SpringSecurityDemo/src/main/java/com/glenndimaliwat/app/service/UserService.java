package com.glenndimaliwat.app.service;

import com.glenndimaliwat.app.domain.User;

public interface UserService {

	public User findByEmail(String email);

}
