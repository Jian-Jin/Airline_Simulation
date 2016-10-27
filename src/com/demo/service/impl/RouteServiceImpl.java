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
import com.demo.service.Utils;

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
			nextRoute.setDepartureTime("00:00");
		}else{
			nextRoute.setDepartureAirportName(routes.get(routes.size()-1).getArrivalAirportName());
			nextRoute.setDepartureTime(routes.get(routes.size()-1).getArrivalTime());
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
	// return false if input departure time is invalid
	@Override
	public int addRoute(int userId, String planeToSet, String planeCurrentLocation, String depatureTime,
			String airportToGo, boolean departureDayPlus) {
		// the unique id of user_aircraft
		int userAircraftId = aircraftDao.getPlaneUniqueId(userId, planeToSet);
		
		Aircraft plane = aircraftDao.getPlaneByUserPlaneId(userAircraftId).get(0);
		int speed = plane.getSpeed();
		Airport fromAirport = airportDao.getAirportByName(planeCurrentLocation);
		Airport toAirport = airportDao.getAirportByName(airportToGo);
		if(toAirport==null || fromAirport.getId()==toAirport.getId()){
			return Utils.AIRPORTERROR;
		}
		double miles = airportService.distance(fromAirport, toAirport);
		int timeInMinutes = (int)(miles/(double)speed * 60);
		
		int hour = timeInMinutes/60;
		int minute = timeInMinutes%60;
		String[] ss = depatureTime.split(":");
		// add to current time
		int departureHour = Integer.valueOf(ss[0]);
		int departureMin = Integer.valueOf(ss[1]);
		hour += departureHour ;
		minute += departureMin;
		// minute should be round up to quarters
		while(minute % 15 !=0){
			minute++;
		}
		hour += minute/60;
		hour = hour % 24;
		minute = minute % 60;
		// if arrival on the next day
		boolean arrivalDayPlus = false;
		if(hour<departureHour){
			arrivalDayPlus = true;
		}
		String result = hour<10? "0"+hour :String.valueOf(hour) ;
		result += ":";
		result += minute<10?"0"+minute : String.valueOf(minute);
		
		List<Route> routes = routeDao.getRoutes(userId, userAircraftId);
		int maxSeq = 0;
		int departDay = 1;
		for(Route r : routes){
			maxSeq = Math.max(r.getSequence(), maxSeq);
			departDay = Math.max(departDay, r.getArrivalDay());
		}
		// if depart time is within 30 mins return error
		for(Route r : routes){
			if(r.getSequence()==maxSeq){
				if(Utils.minuteDiff(r.getArrivalTime(), depatureTime, departureDayPlus)<30)
					return Utils.TIMEERROR;
			}
		}
		if(departureDayPlus) departDay += 1;
		int arrivalDay = arrivalDayPlus? departDay+1 : departDay;
		
		int sequence = maxSeq + 1;
		routeDao.addRoute(userId, userAircraftId, fromAirport.getId(), depatureTime,departDay, toAirport.getId(), result,arrivalDay, sequence);
		return Utils.SUCCESS;
	}
	
	@Override
	public void undoUserRoute(int userId, String planeName) {
		int userAircraftId = aircraftDao.getPlaneUniqueId(userId, planeName);
		List<Route> routes = routeDao.getRoutes(userId, userAircraftId);
		int maxSeq = 0;

		for(Route r : routes){
			maxSeq = Math.max(r.getSequence(), maxSeq);
		}
		routeDao.undoUserRoute(userAircraftId, maxSeq);
		
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
