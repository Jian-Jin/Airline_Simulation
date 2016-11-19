package com.demo.service;

import java.util.List;

import com.demo.model.Aircraft;

public interface AircraftService {
	public List<Aircraft> getPlane();
	public List<Aircraft> buyPlane(int userId, int aircraftId, String customizedName, double firstClassRatio, double businessClassRatio,double captainSalary, double firstOfficerSalary, double attendantSalary, double supportSalary);
	public List<Aircraft> getUserPlanes(int userId);
	List<Aircraft> getPlaneByName(String name);
	List<String> getDownPlanes();
	public void downPlanes(List<String> names);
  
	public void deleteUserAircraft(int userId, String customizedName);
	public void deleteAllUserAircraft(int userId);
	public int getUserAircraftId(int userId, String customizedName);
	
	public Aircraft getUserPlaneByCumstomeizeName(int userId, String customizedName);
	
	public void updateSalary(int userId, String customizedName,double captainSalary, double firstOfficerSalary, double attendantSalary, double supportSalary);
}
