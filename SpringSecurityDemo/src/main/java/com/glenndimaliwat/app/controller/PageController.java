package com.glenndimaliwat.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
	
	@Secured("ROLE_USER")
	@RequestMapping("/user")
	public String userHome() {
		return "Login Success 1!";
	}
	
	@Secured({"ROLE_GUEST","ROLE_USER"})
	@RequestMapping("/guest")
	public String guestHome() {
		return "Login Success 2!";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/admin")
	public String adminHome() {
		return "Login Success 3!";
	}
	
	@RequestMapping("/posts/list")
	public String postList() {
		return "Posts...";
	}
	
	@RequestMapping("/posts/")
	public String list(){
		return "list posts...";
	}
	
	@RequestMapping("/admin/posts/create")
	public String addPost(){
		return "add posts...";
	}
}
