package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.demo.DAO.UserDAO;
import com.demo.model.User;
import com.demo.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private UserDAO userDAO;
	
	public boolean checkLogin(String userName, String passWord) {

		List<User> result = new ArrayList<User>();
		result = userDAO.selectUser(userName,passWord);
		if (result.size()==1) {
			return true;
		} else {
			return false;
		}
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}

