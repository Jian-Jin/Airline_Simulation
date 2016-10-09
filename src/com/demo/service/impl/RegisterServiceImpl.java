package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.demo.DAO.UserDAO;
import com.demo.model.User;
import com.demo.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

	private UserDAO userDAO;
	
	public boolean register(String userName, String passWord, String osuDotnum, boolean superUser) {

		List<User> result = new ArrayList<User>();
		result = userDAO.selectUserByUsername(userName);
		//username already exist
		if(result.size()>0)
			return false;
		userDAO.addUser(userName, passWord, osuDotnum, superUser);
		return true;
		
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}

