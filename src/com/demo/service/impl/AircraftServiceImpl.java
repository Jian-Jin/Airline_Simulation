package com.demo.service.impl;

import java.util.List;

import com.demo.DAO.AircraftDAO;
import com.demo.model.Aircraft;
import com.demo.service.AircraftService;

public class AircraftServiceImpl implements AircraftService{
	private AircraftDAO aircraftDao;

	@Override
	public List<Aircraft> getPlane() {
		return aircraftDao.getPlane();
	}
	
	@Override
	public List<Aircraft> buyPlane(int userId, String aircraftName) {
		int aircraftId = aircraftDao.getPlaneId(aircraftName);
		aircraftDao.buyPlane(userId, aircraftId);
		List<Aircraft> result = aircraftDao.getPlanes(userId);
		System.out.println("====");
		for(Aircraft a : result){
			System.out.println(a.getName());
		}
		return result;
	}

	public AircraftDAO getAircraftDao() {
		return aircraftDao;
	}

	public void setAircraftDao(AircraftDAO aircraftDao) {
		this.aircraftDao = aircraftDao;
	}



}
