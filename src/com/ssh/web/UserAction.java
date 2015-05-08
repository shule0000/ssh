package com.ssh.web;


import java.util.SortedMap;

import com.ssh.core.User;
import com.ssh.service.UserService;

public class UserAction extends BaseAction{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	

	public void register(){
		userService.saveUser(user);
	}
	
	public void delete(){
		userService.deleteUser();
	}
	
	public void update(){
		userService.updateUser();
	}
	
	public void query(){
		@SuppressWarnings("rawtypes")
		SortedMap[] users = userService.executeQuery();
		request.setAttribute("users", users);
		this.forward("register.jsp");
	}
}
