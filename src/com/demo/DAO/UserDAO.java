package com.demo.DAO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.demo.model.User;

public interface UserDAO {
	
	public List<User> selectUser(
			@Param(value = "username") String username,
			@Param(value = "password") String password);
	
	public List<User> selectUserByOsudotnumber(
			@Param(value = "osudotnum") String osudotnum,
			@Param(value = "password") String password);
	
	public List<User> selectUserByUsername(
			@Param(value = "username") String username);
	
	public void addUser(
			@Param(value = "username") String username,
			@Param(value = "password") String password,
			@Param(value = "osudotnum") String osudotnum,
			@Param(value = "superuser") boolean superuser,
			@Param(value = "money") double money);
	
	public List<User> getAllUsers();
	
	public double getInitializeMoney(@Param(value = "id") int id);
	
	public double getUserMoney(@Param(value = "id") int id);
	
	public void updateUserMoney(
			@Param(value = "id") int id,
			@Param(value = "money") double money);
	
	public User getUserById(@Param(value = "id") int id);
	
	public void updateUserOsudotnum(
			@Param(value = "id") int id,
			@Param(value = "osudotnum") String osudotnum);
	public void updateUsername(
					@Param(value = "id") int id,
					@Param(value = "username") String username);
	public void updatePassword(
			@Param(value = "id") int id,
			@Param(value = "password") String password);
	
	public void deleteUser(@Param(value = "id") int id);
	public List<String> getAllUserNames();
	public void addUserMoney(
			@Param(value = "id") int id,
			@Param(value = "money") double money);
	
	public int getIdbyName(@Param(value = "username") String username);
	
	public void deleteClass();
	
}


