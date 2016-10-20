package com.demo.service.impl;

import java.util.List;

import com.demo.DAO.AirportDAO;
import com.demo.model.Airport;
import com.demo.service.AirportService;

public class AirportServiceImpl implements AirportService{
    private AirportDAO airportDao;
    
	@Override
	public Airport getAirport(String name) {
		return airportDao.getAirportByName(name);
	}

	
	/*
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	@Override
	public double distance(Airport a1, Airport a2) {
        double lat1 = a1.getLatitude();
        double lon1 = a1.getLongitude();
        double lat2 = a2.getLatitude();
        double lon2 = a2.getLongitude();
        
	    final int R = 6371; // Radius of the earth

	    Double latDistance = Math.toRadians(lat2 - lat1);
	    Double lonDistance = Math.toRadians(lon2 - lon1);
	    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);
	    // convert to miles
	    return Math.sqrt(distance)/1609.344d;
	}

	/* 
	 * return null if user already owns one hub
	 */
	@Override
	public List<Airport> buyAirport(int userId, String airportName) {
		List<Airport> curairports = airportDao.getAirportsByUserId(userId);
		if(curairports.size()>=1){
			return null;
		}
		int airportId = airportDao.getAirportByName(airportName).getId();
		airportDao.buyAirport(userId, airportId);
		List<Airport> result = airportDao.getAirportsByUserId(userId);
	
		return result;
	}
	
	@Override
	public List<Airport> getMyAirport(int userId){
		return airportDao.getAirportsByUserId(userId);
	}
	
	public AirportDAO getAirportDao() {
		return airportDao;
	}


	public void setAirportDao(AirportDAO airportDAO) {
		this.airportDao = airportDAO;
	}


	@Override
	public List<Airport> getAllAirport() {
		return airportDao.getAllAirport();

	}


	@Override
	public void updateUserAirport(int userId, int airportId) {
		 airportDao.updateUserAirport(userId, airportId);
	}
	
	
}
