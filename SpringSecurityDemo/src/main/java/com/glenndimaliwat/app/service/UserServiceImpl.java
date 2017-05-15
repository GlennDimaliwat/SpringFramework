package com.glenndimaliwat.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glenndimaliwat.app.domain.User;
import com.glenndimaliwat.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public User findByEmail(String email) {

		System.out.println("Inside UserServiceImpl: findByEmail()");
		
		return userRepository.findByEmail(email);
	
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Inside UserServiceImpl: loadUserByUsername()");
		System.out.println("Inside UserServiceImpl: username = "+username);
		/*User user = findByEmail(username);
		
		System.out.println(user.toString());
		
		if ( user == null ) {
			throw new UsernameNotFoundException(username);
		}
		
		UserDetailsImpl userDetails = new UserDetailsImpl(user);
		System.out.println(userDetails.toString());
		//return new UserDetailsImpl(user);
		
		return userDetails;*/
		
		User user = findByEmail(username);
		if( user == null ){
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(user);
	}

}
