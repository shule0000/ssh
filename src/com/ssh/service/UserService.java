package com.ssh.service;

import java.util.SortedMap;

import com.ssh.core.User;
import com.ssh.core.UserDAO;

public class UserService {
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private SqlService sqlService;
	public SqlService getSqlService() {
		return sqlService;
	}

	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}

	public void saveUser(User user) {
		userDAO.save(user);
	}

	public void deleteUser() {
		sqlService.executeDelete("user", 2);
	}

	public void updateUser() {
		sqlService.executeUpdate("update user set username='shule' where id=?",
				new Object[]{1});
	}

	@SuppressWarnings("rawtypes")
	public SortedMap[] executeQuery() {
		return sqlService.executeQuery("select * from user", null);
	}
}
