package com.glenndimaliwat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.glenndimaliwat.service.UsersService;
import com.glenndimaliwat.model.Users;

@Controller
public class UsersController {
	@Autowired
	UsersService usersService;
	
	/*
	 * Go to Users page and Load User Form
	 */
	@RequestMapping(value="/start")
	public String loadUsersForm(Map<String, Object> map) {
		Users user = new Users();
		map.put("user", user);
		map.put("userList", usersService.getAllUsers());
		return "users";
	}
	
	/*
	 * Perform Users actions
	 */
	@RequestMapping(value = "/user.do", method = RequestMethod.POST)
	public String userActions(@ModelAttribute Users user, BindingResult result, @RequestParam String action, Map<String, Object> map) {
		try {
			Users userResult = new Users();
	
			if(action.toLowerCase().equalsIgnoreCase("add")) {
				usersService.add(user);
				userResult = user;
			}
			else if(action.toLowerCase().equalsIgnoreCase("edit")) {
				usersService.edit(user);
				userResult = user;
			}
			else if(action.toLowerCase().equalsIgnoreCase("delete")) {
				usersService.delete(user.getIdUsers());
				userResult = user;
			}
			else if(action.toLowerCase().equalsIgnoreCase("search")) {
				Users searchedUser = usersService.getUser(user.getIdUsers());
				userResult = searchedUser!=null ? searchedUser : new Users();
			}
			map.put("user", userResult);
			map.put("userList", usersService.getAllUsers());
			
			return "users";
		}
		catch(Exception e) {
			map.put("user", new Users());
			map.put("userList", usersService.getAllUsers());
			return "users";
		}
	}
}
