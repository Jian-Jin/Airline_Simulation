package com.demo.service;

import com.demo.model.User;

public interface LoginService {
	
	public User checkLogin(String userName,String passWord);
	
}
