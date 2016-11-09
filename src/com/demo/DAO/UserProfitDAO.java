package com.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.model.UserProfit;

public interface UserProfitDAO {
	public List<UserProfit> getAllProfit();
	public void storeUserProfit(@Param(value = "userId") int userId,@Param(value = "profit") double profit);
	public void clearUserProfit();
	
	public void clearSimulateTime();
	public String getSimulateTime();
	public void storeSimulateTime(@Param(value = "time") String time);
	public void deleteUserProfit(@Param(value = "userId") int userId);
}
