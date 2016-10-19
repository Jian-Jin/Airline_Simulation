package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUser(String userName,String passWord);
	public List<User> generateUser(int userNumber);
	public double getUserMoney(int id);
	public void updateUserMoney(int id, double money);
	public User getUserById(int id);
}
