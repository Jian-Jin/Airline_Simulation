package com.demo.service.impl;

import java.util.List;

import com.demo.DAO.UserDAO;
import com.demo.model.User;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO userDao;

	@Override
	public List<User> getUser() {
		return userDao.getUser();
	}
	

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}



}
