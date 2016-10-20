package com.demo.service;

import java.util.List;

import com.demo.model.Aircraft;

public interface AircraftService {
	public List<Aircraft> getPlane();
	public List<Aircraft> buyPlane(int userId, int aircraftId, String customizedName, double firstClassRatio, double businessClassRatio2);
	public List<Aircraft> getUserPlanes(int userId);
	List<Aircraft> getPlaneByName(String name);
	List<String> getDownPlanes();
	public void downPlanes(List<String> names);
  
	public void deleteUserAircraft(int userId, String customizedName);
	
	public int getUserAircraftId(int userId, String customizedName);
}
