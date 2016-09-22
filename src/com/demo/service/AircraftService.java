package com.demo.service;

import java.util.List;

import com.demo.model.Aircraft;

public interface AircraftService {
	public List<Aircraft> getPlane();
	public List<Aircraft> buyPlane(int userId, String aircraftName);
  
}
