package com.demo.service.impl;

import java.util.*;
import java.util.List;

import com.demo.DAO.UserDAO;
import com.demo.model.User;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService{
	private static char[] chars="abcdefghihklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private UserDAO userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	@Override
	public User getUser(String userName, String passWord) {
		List<User> result = new ArrayList<User>();
		result = userDao.selectUser(userName,passWord);
		if (result.size()==1) {
			return result.get(0);
		} else {
			return null;
		}
	}


	@Override
	public List<User> generateUser(int userNumber) {
		List<User> result = new ArrayList<User>();
		Set<String> names = new HashSet<String>();
		List<User> users = getAllUsers();
		for(User u : users){
			names.add(u.getName());
		}
		int count = 0;
		while(count<userNumber){
			String userName = getRandomString(5);
			String passwd = getRandomString(6);
			if(names.contains(userName))
				continue;
			userDao.addUser(userName, passwd, "", false);
			User user = new User();
			user.setName(userName);
			user.setPassword(passwd);
			result.add(user);
			count++;
		}
		return result;
		
	}
	private String getRandomString(int length){
		StringBuilder sb = new StringBuilder();
		int l = chars.length;
		Random r = new Random();
		for(int i =0;i<length;i++){
			int index = r.nextInt(l);
			sb.append(chars[index]);
		}
		return sb.toString();
		
	}



}
