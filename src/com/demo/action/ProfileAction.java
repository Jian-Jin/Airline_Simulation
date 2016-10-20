package com.demo.action;

import java.util.List;
import java.util.Map;

import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.User;
import com.demo.service.AircraftService;
import com.demo.service.AirportService;
import com.demo.service.RouteService;
import com.demo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction  extends ActionSupport {
	private User user;
	private List<Airport> userAirports;
	private List<Aircraft> userPlanes;
	private String errorMsg;
	private UserService userService;
	private int millions;
	private AircraftService aircraftService;
	private AirportService airportService;
	private RouteService routeService;
	private String aircraftCustomizeNameToDelete;
	private String airportToDelete;
	
	public String getUserProfile(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
	    User curUser = userService.getUserById(userId);
	    setMillions((int)(curUser.getMoney()/1000000));
	    setUser(curUser);
	    return SUCCESS;
	}
	
	public String getUserAirport(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
	    List<Airport> airports = airportService.getMyAirport(userId);
	    setUserAirports(airports);
	    return SUCCESS;
	}
	
	public String getUserAircrafts(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
	    List<Aircraft> aircrafts = aircraftService.getUserPlanes(userId);
	    setUserPlanes(aircrafts);
	    return SUCCESS;
	}

	public String deleteUserAircrafts(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(aircraftCustomizeNameToDelete==null || aircraftCustomizeNameToDelete.isEmpty() ){
	    	setErrorMsg("Please choose an aircraft to delete");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
	    Aircraft deleteAirtcraft = null;
	    List<Aircraft> userPlanes = aircraftService.getUserPlanes(userId);
	    for(Aircraft aircraft : userPlanes){
	    	if(aircraft.getCustomizedName().equals(aircraftCustomizeNameToDelete)){
	    		deleteAirtcraft = aircraft;
	    		userPlanes.remove(aircraft);
	    		break;
	    	}
	    }
	    setUserPlanes(userPlanes);
	    int aircraftId = deleteAirtcraft.getId();
	    double cost = deleteAirtcraft.getCost()*1000000;
	    //increase the money
	    double money = userService.getUserMoney(userId);
	    money += cost;
	    userService.updateUserMoney(userId, money);
	    routeService.deleteUserRouteByAircraftId(userId, aircraftId);
	    aircraftService.deleteUserAircraft(userId, aircraftCustomizeNameToDelete);
	    return SUCCESS;
	}
	
	public List<Airport> getUserAirports() {
		return userAirports;
	}

	public void setUserAirports(List<Airport> userAirports) {
		this.userAirports = userAirports;
	}

	public List<Aircraft> getUserPlanes() {
		return userPlanes;
	}

	public void setUserPlanes(List<Aircraft> userPlanes) {
		this.userPlanes = userPlanes;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public int getMillions() {
		return millions;
	}

	public void setMillions(int millions) {
		this.millions = millions;
	}

	public AircraftService getAircraftService() {
		return aircraftService;
	}

	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	public AirportService getAirportService() {
		return airportService;
	}

	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}

	public RouteService getRouteService() {
		return routeService;
	}

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}


	public String getAircraftCustomizeNameToDelete() {
		return aircraftCustomizeNameToDelete;
	}

	public void setAircraftCustomizeNameToDelete(String aircraftCustomizeNameToDelete) {
		this.aircraftCustomizeNameToDelete = aircraftCustomizeNameToDelete;
	}

	public String getAirportToDelete() {
		return airportToDelete;
	}

	public void setAirportToDelete(String airportToDelete) {
		this.airportToDelete = airportToDelete;
	}
	
	
}
