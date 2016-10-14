package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUser(String userName,String passWord);
	public List<User> generateUser(int userNumber);

  
}
