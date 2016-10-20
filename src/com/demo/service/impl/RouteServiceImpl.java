package com.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.DAO.AircraftDAO;
import com.demo.DAO.AirportDAO;
import com.demo.DAO.RouteDAO;
import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.Route;
import com.demo.service.AirportService;
import com.demo.service.RouteService;

public class RouteServiceImpl implements RouteService{
	private AircraftDAO aircraftDao;
	private AirportDAO airportDao;
	private RouteDAO routeDao;
	private AirportService airportService;
	private Map<Integer, Airport> airports = new HashMap<Integer, Airport>();

	@Override
	public List<Route> getAircraftRoutes(int userId, String planeName) {
		int userAircraftId = aircraftDao.getPlaneUniqueId(userId, planeName);
		
		List<Route> routes = routeDao.getRoutes(userId, userAircraftId);
		populateAirport();
		for(Route r : routes){
			r.setDepartureAirportName(airports.get(r.getFromAirport()).getName());
			r.setArrivalAirportName(airports.get(r.getToAirport()).getName());
		}
		// the last element used to store the info of the current plane location
		Route nextRoute = new Route();
		if(routes.isEmpty()){
			String airport = airportDao.getAirportsByUserId(userId).get(0).getName();
			nextRoute.setDepartureAirportName(airport);
		}else{
			nextRoute.setDepartureAirportName(routes.get(routes.size()-1).getArrivalAirportName());
		}
		routes.add(nextRoute);
		return routes;
		
	}
	
	private void populateAirport(){
		if(airports.isEmpty()){
			List<Airport> list = airportDao.getAllAirport();
			for(Airport a :list){
				airports.put(a.getId(), a);
			}
		}
	}
	@Override
	public void addRoute(int userId, String planeToSet, String planeCurrentLocation, String depatureTime,
			String airportToGo) {
		// the unique id of user_aircraft
		int userAircraftId = aircraftDao.getPlaneUniqueId(userId, planeToSet);
		
		Aircraft plane = aircraftDao.getPlaneByUserPlaneId(userAircraftId).get(0);
		int speed = plane.getSpeed();
		Airport fromAirport = airportDao.getAirportByName(planeCurrentLocation);
		Airport toAirport = airportDao.getAirportByName(airportToGo);
		double miles = airportService.distance(fromAirport, toAirport);
		//double miles =  distanceInMeter / 1609.344d;
		int timeInMinutes = (int)(miles/(double)speed * 60);
		int hour = timeInMinutes/60;
		int minute = timeInMinutes%60;
		String[] ss = depatureTime.split(":");
		hour += Integer.valueOf(ss[0]);
		minute += Integer.valueOf(ss[1]);
		hour += hour + minute/60;
		hour = hour % 24;
		minute = minute % 60;
		String result = hour<10? "0"+hour :String.valueOf(hour) ;
		result += ":";
		result += minute<10?"0"+minute : String.valueOf(minute);
		
		List<Route> routes = routeDao.getRoutes(userId, userAircraftId);
		int maxSeq = 0;
		for(Route r : routes){
			maxSeq = Math.max(r.getSequence(), maxSeq);
		}
		int sequence = maxSeq + 1;
		routeDao.addRoute(userId, userAircraftId, fromAirport.getId(), depatureTime, toAirport.getId(), result, sequence);
		
	}

	public AircraftDAO getAircraftDao() {
		return aircraftDao;
	}

	public void setAircraftDao(AircraftDAO aircraftDao) {
		this.aircraftDao = aircraftDao;
	}

	public AirportDAO getAirportDao() {
		return airportDao;
	}

	public void setAirportDao(AirportDAO airportDao) {
		this.airportDao = airportDao;
	}

	public RouteDAO getRouteDao() {
		return routeDao;
	}

	public void setRouteDao(RouteDAO routeDao) {
		this.routeDao = routeDao;
	}

	public AirportService getAirportService() {
		return airportService;
	}

	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}

	@Override
	public void deleteUserRouteByAircraftId(int userId, int aircraftId) {
		this.routeDao.deleteUserRouteByAircraftId(userId, aircraftId);
		
	}

	@Override
	public void deleteUserRoute(int userId) {
		this.routeDao.deleteUserRoute(userId);
		
	}


}
