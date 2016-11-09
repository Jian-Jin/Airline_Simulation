package com.demo.service;

import java.util.List;

import com.demo.model.UserProfit;

public interface SimulateService {

	public void runSimulate(double fuelPrice, double basicProfit);
	
	public List<UserProfit> getProfits();
	
	public String getSimulateRunTime();
	
	public void deleteUserProfit(int userId);
}
