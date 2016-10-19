package com.demo.DAO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.demo.model.User;

public interface UserDAO {
	
	public List<User> selectUser(
			@Param(value = "username") String username,
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
	
}
