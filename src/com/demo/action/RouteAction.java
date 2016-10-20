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
	
	private String hour;
	private String min;
	private String airportToGo;
	//private List<String> timeslots;
	private List<String> hours;
	private List<String> mins;
	private List<String> airports;
	
	private static String dayPlusText="(Day+1)";

	/**
	 * Route setup home page, show all the aircrafts of the user 
	 * a select list of planes name to choose from
	 */
	public String getRoute(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");

		planes = aircraftService.getUserPlanes(userId);
		if(planes==null || planes.isEmpty()){
			setErrorMsg("You have no aircrafts yet");
	    	return ERROR;
		}
		myPlanes = new ArrayList<String>();
		for(Aircraft a : planes){
			myPlanes.add(a.getCustomizedName());
		}
		return SUCCESS;
	}
	
	
	/**
	 * return the route page of one specific aircraft  after passing in planeToSet
	 */
	public String aircraftRoute(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
	    if(getPlaneToSet()==null || getPlaneToSet().isEmpty()){
	    	setErrorMsg("Please choose an aircraft first");
	    	return ERROR;
	    }
	    if(airportService.getMyAirport(userId).isEmpty()){
	    	setErrorMsg("Please buy a hub first in airport page");
	    	return ERROR;
	    }
		String planeName = planeToSet;
		
		session.put("routePlane", planeName);

		routes = routeService.getAircraftRoutes(userId, planeName);
		Route nextRoute = routes.get(routes.size()-1);
		setPlaneCurrentLocation(nextRoute.getDepartureAirportName());
		routes.remove(routes.size()-1);
		String[] ss = nextRoute.getDepartureTime().split(":");
		int currentHour = Integer.valueOf(ss[0]);
		int currentMin = Integer.valueOf(ss[1]);
		populateTimeSlots(currentHour, currentMin);
		session.put("planeCurLocation", planeCurrentLocation);
		return SUCCESS;
	}
	
	/**
	 *  populate variable airports and timeslots used to be shown in selector list
	 */
	private void populateTimeSlots(int currentHour, int currentMin){
		if(airports == null || airports.isEmpty()){
			airports = new ArrayList<String>();
			List<Airport> list = airportService.getAllAirport();
			for(Airport a : list){
				airports.add(a.getName());
			}
		}
		
		if(hours == null || hours.isEmpty()){
			hours = new ArrayList<String>();
			for(int i=0;i<24;i++){
				int h = (currentHour + i)%24;
				String s ="";
				if(h<10){
					s+="0";
				}
				s+=h;
				if(h<currentHour){
					s+=dayPlusText;
				}
				hours.add(s);
			}
		}
		if(mins == null || mins.isEmpty()){
			mins = new ArrayList<String>();
			for(int i=0;i<60;i+=5){
				String s ="";
				if(i<10){
					s+="0";
				}
				s+=i;
				mins.add(s);
			}
		}
	}
	
	/**
	 * add a new route of a airplane's route list
	 * parameters passed in : depatureTime, airportToGo
	 */
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
		
		if(planeLocation.equals(airportToGo) || airportToGo.contains("arrival")){
			setErrorMsg("invalid arrival aiport");
	    	return ERROR;
		}
		boolean dayPlus = false;
		if(hour.contains(dayPlusText)){
			hour = hour.split(" ")[0];
			dayPlus = true;
		}
			
		String depatureTime = hour+":"+min;

		routeService.addRoute(userId,planeName,planeLocation,depatureTime,airportToGo, dayPlus);

		routes = routeService.getAircraftRoutes(userId, planeName);
		Route nextRoute = routes.get(routes.size()-1);
		session.put("planeCurLocation", nextRoute.getDepartureAirportName());
		String[] ss = nextRoute.getDepartureTime().split(":");
		int currentHour = Integer.valueOf(ss[0]);
		int currentMin = Integer.valueOf(ss[1]);
		populateTimeSlots(currentHour, currentMin);

		routes.remove(routes.size()-1);

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


//	public String getDepatureTime() {
//		return depatureTime;
//	}
//
//
//	public void setDepatureTime(String depatureTime) {
//		this.depatureTime = depatureTime;
//	}


	public String getAirportToGo() {
		return airportToGo;
	}


	public void setAirportToGo(String airportToGo) {
		this.airportToGo = airportToGo;
	}


//	public List<String> getTimeslots() {
//		return timeslots;
//	}
//
//
//	public void setTimeslots(List<String> timeslots) {
//		this.timeslots = timeslots;
//	}


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


	public String getHour() {
		return hour;
	}


	public void setHour(String hour) {
		this.hour = hour;
	}


	public String getMin() {
		return min;
	}


	public void setMin(String min) {
		this.min = min;
	}


	public List<String> getHours() {
		return hours;
	}


	public void setHours(List<String> hours) {
		this.hours = hours;
	}


	public List<String> getMins() {
		return mins;
	}


	public void setMins(List<String> mins) {
		this.mins = mins;
	}
	
	
	
}
