package com.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.DAO.AircraftDAO;
import com.demo.DAO.AirportDAO;
import com.demo.DAO.RouteDAO;
import com.demo.DAO.UserDAO;
import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.Route;
import com.demo.model.User;
import com.demo.service.AirportService;
import com.demo.service.RouteService;
import com.demo.service.Utils;

public class RouteServiceImpl implements RouteService{
	private AircraftDAO aircraftDao;
	private AirportDAO airportDao;
	private RouteDAO routeDao;
	private UserDAO userDao;
	private AirportService airportService;
	private Map<Integer, Airport> airports = new HashMap<Integer, Airport>();


	@Override
	public List<Route> getAircraftRoutes(int userId, String planeName) {
		int userAircraftId = aircraftDao.getPlaneUniqueId(userId, planeName);
		
		List<Route> routes = routeDao.getRoutes(userId, userAircraftId);
		populateAirport();
		for(Route r : routes){
			r.setDepartureAirportIdentifier(airports.get(r.getFromAirport()).getIdentifier());
			r.setArrivalAirportIdentifier(airports.get(r.getToAirport()).getIdentifier());
		}
		// the last element used to store the info of the current plane location
		Route nextRoute = new Route();
		if(routes.isEmpty()){
			String airport = airportDao.getAirportsByUserId(userId).get(0).getIdentifier();
			nextRoute.setDepartureAirportIdentifier(airport);
			nextRoute.setDepartureTimeLocal("00:00");
		}else{
			nextRoute.setDepartureAirportIdentifier(routes.get(routes.size()-1).getArrivalAirportIdentifier());
			nextRoute.setDepartureTimeLocal(routes.get(routes.size()-1).getArrivalTimeLocal());
		}
		routes.add(nextRoute);
		return routes;
		
	}
	
	


	@Override
	public List<Route> getProfitDetails(int userId) {
		populateAirport();
		// admin-- get all user's routes
		if(userId < 0){
			List<Route> routes = routeDao.getAllRoutes();
			Map<Integer,List<Route>> userRouteMap = new HashMap<Integer,List<Route>>();
			// key userAircraftId
			Map<Integer,Aircraft> userAircraftMap = new HashMap<Integer,Aircraft>();
			
			for(Route r : routes){
				Aircraft plane = userAircraftMap.get(r.getUserAircraftId());
				if(plane == null){
					plane = aircraftDao.getPlaneByUserAircraftId(r.getUserAircraftId()).get(0);
					userAircraftMap.put(r.getUserAircraftId(), plane);
				}
				r.setAircraft(plane);
				r.setAirplaneName(plane.getCustomizedName());
				List<Route> list = userRouteMap.get(r.getUserId());
				if(list == null){
					list = new ArrayList<Route>();
					userRouteMap.put(r.getUserId(), list);
				}
				list.add(r);

			}
			for(int uid : userRouteMap.keySet()){
				User user = userDao.getUserById(uid);
				for(Route r : userRouteMap.get(uid)){
					r.setDepartureAirportIdentifier(airports.get(r.getFromAirport()).getIdentifier());
					r.setArrivalAirportIdentifier(airports.get(r.getToAirport()).getIdentifier());
					r.setUser(user);
				}
			}
			return routes;
			
		}else{
			User user = userDao.getUserById(userId);
			List<Route> routes = routeDao.getUserProfitRoutes(userId);
			for(Route r : routes){
				r.setDepartureAirportIdentifier(airports.get(r.getFromAirport()).getIdentifier());
				r.setArrivalAirportIdentifier(airports.get(r.getToAirport()).getIdentifier());
				r.setUser(user);
			}
			return routes;
		}
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
	// the input depatureTime is local time
	@Override
	public int addRoute(int userId, String planeToSet, String planeCurrentLocation, String depatureTimeLocal,
			String airportToGo, int departureDayPlusLocal) {
		
		// the unique id of user_aircraft
		int userAircraftId = aircraftDao.getPlaneUniqueId(userId, planeToSet);
				
		Aircraft plane = aircraftDao.getPlaneByUserPlaneId(userAircraftId).get(0);
		int speed = plane.getSpeed();
		Airport fromAirport = airportDao.getAirportByIdentifier(planeCurrentLocation);
		Airport toAirport = airportDao.getAirportByName(airportToGo);
		if(toAirport==null || fromAirport.getId()==toAirport.getId()){
			return Utils.AIRPORTERROR;
		}	
				
		// get the last route with max sequence of this plane
		List<Route> routes = routeDao.getRoutes(userId, userAircraftId);
		int maxSeq = 0;
		//int departDayZulu = 1;
		int departureDayLocal = 1;
		for(Route r : routes){
			maxSeq = Math.max(r.getSequence(), maxSeq);
			//departDayZulu = Math.max(departDayZulu, r.getArrivalDayZulu());
			departureDayLocal = Math.max(departureDayLocal, r.getArrivalDayLocal());
		}
		// if depart time is within 30 mins return error
		for(Route r : routes){
			if(r.getSequence()==maxSeq){
				if(Utils.minuteDiff(r.getArrivalTimeLocal(), depatureTimeLocal, departureDayPlusLocal==1)<30)
					return Utils.TIMEERROR;
			}
		}
		
		
		// get flight time length
		double miles = airportService.distance(fromAirport, toAirport);
		int flyTimeInMinutes = (int)(miles/(double)speed * 60);
		
		int flyHour = flyTimeInMinutes/60;
		int flyMinute = flyTimeInMinutes%60;
		
		
		String[] ss = depatureTimeLocal.split(":");
		// convert departure local time to zulu
		int departureHourLocal = Integer.valueOf(ss[0]);
		int departureMin = Integer.valueOf(ss[1]);
		int timezone = fromAirport.getTimeZone();
		departureDayLocal += departureDayPlusLocal;
		int[] time = new int[]{departureHourLocal,timezone,departureDayLocal};
		Utils.convertFromLocalToZulu(time);
		int departureHourZulu = time[0];
		int departureDayZulu = time[2];
		
		// get arrival zulu time first
		int arrivalHourZulu = departureHourZulu;
		int arrivalMin = departureMin;
		arrivalHourZulu += flyHour ;
		arrivalMin += flyMinute;
		// minute should be round up to quarters
		while(arrivalMin % 15 !=0){
			arrivalMin++;
		}
		
		arrivalHourZulu += arrivalMin/60;
		arrivalHourZulu = arrivalHourZulu % 24;
		arrivalMin = arrivalMin % 60;
		// if arrival on the next day
		int arrivalDayPlusZulu = 0;
		if(arrivalHourZulu<departureHourZulu){
			arrivalDayPlusZulu ++;
		}
		
		int arrivalDayZulu = departureDayZulu + arrivalDayPlusZulu;
		// convert arrival zulu time to local 
		int[] arrivalTime = new int[]{arrivalHourZulu, toAirport.getTimeZone(),arrivalDayZulu};
		Utils.convertFromZuluToLocal(arrivalTime);
		int arrivalHourLocal = arrivalTime[0];
		int arrivalDayLocal = arrivalTime[2];
		
		// convert to regarding hour:min format
		String departureZuluString = Utils.getTimeString(departureHourZulu, departureMin);
		String departureLocalString = Utils.getTimeString(departureHourLocal, departureMin);
		String arrivalZuluString = Utils.getTimeString(arrivalHourZulu, arrivalMin);
		String arrivalLocalString = Utils.getTimeString(arrivalHourLocal, arrivalMin);
		
		
		int sequence = maxSeq + 1;
		String filghtTime = Utils.getFlyTimeString(departureZuluString, arrivalZuluString);
		routeDao.addRoute(userId, userAircraftId, fromAirport.getId(),toAirport.getId(),
				departureLocalString,departureDayLocal, arrivalLocalString,arrivalDayLocal,
				departureZuluString,departureDayZulu,arrivalZuluString,arrivalDayZulu,
				sequence,filghtTime);
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




	public UserDAO getUserDao() {
		return userDao;
	}




	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	

}
