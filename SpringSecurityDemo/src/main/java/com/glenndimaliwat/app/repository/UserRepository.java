package com.glenndimaliwat.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.glenndimaliwat.app.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
