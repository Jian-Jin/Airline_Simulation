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
			@Param(value = "password") String password);
}
