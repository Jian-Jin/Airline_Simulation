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
	public List<Aircraft> getPlaneByName(String name) {
		return aircraftDao.getPlaneByName(name);
	}

	
	@Override
	public List<Aircraft> buyPlane(int userId, int aircraftId, String customizedName, double firstClassRatio,
			double businessClassRatio,double captainSalary, double firstOfficerSalary, double attendantSalary, double supportSalary) {
		aircraftDao.buyPlane(userId, aircraftId, customizedName, firstClassRatio, businessClassRatio, captainSalary,  firstOfficerSalary,  attendantSalary,  supportSalary);
		return getUserPlanes(userId);
	}
	
	@Override
	public List<String> getDownPlanes() {
		return aircraftDao.getDownPlanes();
	}
	
	

	public AircraftDAO getAircraftDao() {
		return aircraftDao;
	}

	public void setAircraftDao(AircraftDAO aircraftDao) {
		this.aircraftDao = aircraftDao;
	}

	@Override
	public List<Aircraft> getUserPlanes(int userId) {
		return aircraftDao.getUserPlanes(userId);
	}
	@Override
	public void downPlanes(List<String> names) {
		aircraftDao.cleanDownPlanes();
		for(String plane : names){
			aircraftDao.downPlane(plane);
		}
		
	}
	@Override
	public void deleteUserAircraft(int userId, String customizedName) {
		this.aircraftDao.deleteUserAircraft(userId, customizedName);
	}
	
	@Override
	public void deleteAllUserAircraft(int userId){
		this.aircraftDao.deleteAllUserAircraft(userId);
	}
	@Override
	public int getUserAircraftId(int userId, String customizedName) {
		return aircraftDao.getPlaneUniqueId(userId, customizedName);
	}
	@Override
	public Aircraft getUserPlaneByCumstomeizeName(int userId, String customizedName) {
		return aircraftDao.getUserPlaneByCumstomeizeName(userId, customizedName);
	}
	@Override
	public void updateSalary(int userId, String customizedName, double captainSalary, double firstOfficerSalary,
			double attendantSalary, double supportSalary) {
		 this.aircraftDao.updateSalary(userId, customizedName, captainSalary, firstOfficerSalary, attendantSalary, supportSalary);	
	}




}
