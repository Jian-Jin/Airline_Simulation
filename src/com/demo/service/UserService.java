package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {
	public List<User> getAllUsers();
	public void deleteUser(int id);
	public User getUser(String userName,String passWord);
	public User getUserFromUsername(String userName);
	public List<User> generateUser(String userNames);
	public double getUserMoney(int id);
	public void updateUserMoney(int id, double money);
	public User getUserById(int id);
	public void updateUserOsudotnumber(int id, String osudotnumber);
	public void updateUsername(int id, String username);
	public void updatePassword(int id, String password);
}
