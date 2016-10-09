package com.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.Route;
import com.demo.service.AircraftService;
import com.demo.service.AirportService;
import com.demo.service.RouteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RouteAction extends ActionSupport{
	private AircraftService aircraftService;
	private AirportService airportService;
	private List<Aircraft> planes;
	private List<String> myPlanes;
	private String errorMsg;
	private String planeToSet;
	private List<Route> routes;
	private RouteService routeService;
	private String planeCurrentLocation;
	private String depatureTime;
	private String airportToGo;
	private List<String> timeslots;
	private List<String> airports;


	public String getRoute(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");

		planes = aircraftService.getPlanes(userId);
		if(planes==null || planes.isEmpty()){
			setErrorMsg("You have no aircrafts yet");
	    	return ERROR;
		}
		myPlanes = new ArrayList<String>();
		for(Aircraft a : planes){
			myPlanes.add(a.getName());
		}
		return SUCCESS;
	}
	
	
	public String aircraftRoute(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
		String planeName = planeToSet;
		routes = routeService.getAircraftRoutes(userId, planeName);
		Route nextRoute = routes.get(routes.size()-1);
		setPlaneCurrentLocation(nextRoute.getDepartureAirportName());
		routes.remove(routes.size()-1);
	
		populateTimeSlots();
		session.put("routePlane", planeName);
		session.put("planeCurLocation", planeCurrentLocation);
		return SUCCESS;
	}
	
	private void populateTimeSlots(){
		if(airports == null || airports.isEmpty()){
			airports = new ArrayList<String>();
			List<Airport> list = airportService.getAllAirport();
			for(Airport a : list){
				airports.add(a.getName());
			}
		}
		
		if(timeslots == null || timeslots.isEmpty()){
			timeslots = new ArrayList<String>();
			for(int i=0;i<24;i++){
				String s ="";
				if(i<10){
					s+="0";
				}
				s+=i;
				timeslots.add(s+":00");
				timeslots.add(s+":30");
			}
		}
	}
	
	public String addRoute(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
	    String planeName = (String)session.get("routePlane");
	    String planeLocation = (String)session.get("planeCurLocation");
	    setPlaneToSet(planeName);
		
		populateTimeSlots();
		routeService.addRoute(userId,planeName,planeLocation,depatureTime,airportToGo);
		System.out.println("===="+depatureTime);
//		return aircraftRoute();
		routes = routeService.getAircraftRoutes(userId, planeName);
		Route nextRoute = routes.get(routes.size()-1);
		setPlaneCurrentLocation(nextRoute.getDepartureAirportName());
		routes.remove(routes.size()-1);
		session.put("routePlane", planeName);
		session.put("planeCurLocation", planeCurrentLocation);
		return SUCCESS;
	}


	public AircraftService getAircraftService() {
		return aircraftService;
	}


	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}


	public List<Aircraft> getPlanes() {
		return planes;
	}


	public void setPlanes(List<Aircraft> planes) {
		this.planes = planes;
	}


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public List<String> getMyPlanes() {
		return myPlanes;
	}


	public void setMyPlanes(List<String> myPlanes) {
		this.myPlanes = myPlanes;
	}


	public String getPlaneToSet() {
		return planeToSet;
	}


	public void setPlaneToSet(String planeToSet) {
		this.planeToSet = planeToSet;
	}


	public List<Route> getRoutes() {
		return routes;
	}


	public void setRountes(List<Route> routes) {
		this.routes = routes;
	}


	public RouteService getRouteService() {
		return routeService;
	}


	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}


	public String getPlaneCurrentLocation() {
		return planeCurrentLocation;
	}


	public void setPlaneCurrentLocation(String planeCurrentLocation) {
		this.planeCurrentLocation = planeCurrentLocation;
	}


	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}


	public String getDepatureTime() {
		return depatureTime;
	}


	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}


	public String getAirportToGo() {
		return airportToGo;
	}


	public void setAirportToGo(String airportToGo) {
		this.airportToGo = airportToGo;
	}


	public List<String> getTimeslots() {
		return timeslots;
	}


	public void setTimeslots(List<String> timeslots) {
		this.timeslots = timeslots;
	}


	public List<String> getAirports() {
		return airports;
	}


	public void setAirports(List<String> airports) {
		this.airports = airports;
	}


	public AirportService getAirportService() {
		return airportService;
	}


	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}
	
	
	
}
