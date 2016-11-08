package com.demo.service.impl;

import java.util.*;
import java.util.List;
import com.demo.DAO.UserDAO;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.service.Utils;

public class UserServiceImpl implements UserService{
	private static char[] chars="abcdefghihklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private UserDAO userDao;

	@Override
	public List<User> getAllUsers() {
		List<User> result = userDao.getAllUsers();
		for(User u : result){
			double money = u.getMoney();
			u.setMoneyString(Utils.convertToMillion(money));
		}
		return result;
	}
	

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User getUserFromUsername(String username){
		List<User> result = new ArrayList<User>();
		result = userDao.selectUserByUsername(username);
		if(result.size() == 1){
			return result.get(0);
		}
		else return null;
	}
	@Override
	public User getUser(String userName, String passWord) {
		List<User> result = new ArrayList<User>();
		result = userDao.selectUser(userName,passWord);
		if(result.size()==0)
			result = userDao.selectUserByOsudotnumber(userName, passWord);
		if (result.size()==1) {
			return result.get(0);
		} else {
			return null;
		}
	}


	/* 
	 * an empty list will be returned if names is not valid
	 */
	@Override
	public List<User> generateUser(String names) {
		List<User> result = new ArrayList<User>();
		if(!checkNewUserNames(names)){
			return result;
		}
		names = names.trim().replace("\n", "").replace("\r", "");

		String[] userNames = names.split(",");
		for(String name : userNames){
			name = name.trim();
			String passwd = getRandomString(6);
			
			//get the initialize money, id = 1 ,first row
			double money = userDao.getInitializeMoney(1);
			userDao.addUser(name, passwd, "", false,money);
			User user = new User();
			user.setName(name);
			user.setPassword(passwd);
			result.add(user);
		}
		return result;
		
	}
	
	private boolean checkNewUserNames(String names){
		if(names.isEmpty()){
			return false;
		}
		String s = names.trim().replace("\n", "").replace("\r", "");
		String[] usernames = s.split(",");
		List<String> currentNames = userDao.getAllUserNames();
		Set<String> set = new HashSet<String>();
		set.addAll(currentNames);
		for(String name : usernames){
			if(name==null || name.isEmpty()){
				return false;
			}
			if(set.contains(name)){
				return false;
			}else{
				set.add(name);
			}
		}
		
		return true;
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

	@Override
	public double getUserMoney(int id){
		return userDao.getUserMoney(id);
	}

	@Override
	public void updateUserMoney(int id, double money){
		userDao.updateUserMoney(id, money);
	}
	
	@Override
	public User getUserById(int id){
		return userDao.getUserById(id);
	}
	
	@Override
	public void deleteUser(int id){
		this.userDao.deleteUser(id);
	}

	@Override
	public void updateUserOsudotnumber(int id, String osudotnumber) {
		userDao.updateUserOsudotnum(id, osudotnumber);
	}
	@Override
	public void updateUsername(int id, String username) {
		userDao.updateUsername(id, username);
	}
	@Override
	public void updatePassword(int id, String password) {
		userDao.updatePassword(id, password);
	}
	

}
