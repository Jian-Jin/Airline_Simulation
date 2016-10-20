package com.demo.action;

import java.util.List;
import java.util.Map;

import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.service.AirportService;
import com.demo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AirportAction extends ActionSupport{
  private AirportService airportService;
  private UserService userService;
  private String fromAirportName;
  private String toAirportName;
  private String distance;
  private Airport fromAirport;
  private Airport toAirport;
  private String errorMsg;
  private String airportToBuy;
  private List<Airport> userAirport;

  
  public String airportHome(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");

	  setUserAirport(airportService.getMyAirport(userId));
	  return SUCCESS;
  }
public String getAirport(){
	  fromAirport = airportService.getAirport(fromAirportName);
	  toAirport = airportService.getAirport(toAirportName);
	  System.out.println(fromAirportName);
	  System.out.println(toAirportName);

	  if(fromAirport == null || toAirport == null){
		  setErrorMsg("invalid airport input");
		  return ERROR;
	  }
	  distance = String.valueOf(airportService.distance(fromAirport, toAirport));
	  return SUCCESS;
	  
  }

public String buyAirport(){
	Map session = ActionContext.getContext().getSession();
    if(session.get("logined")==null){
    	setErrorMsg("Please sign in first");
    	return ERROR;
    }
    if(airportToBuy==null || airportToBuy.isEmpty()){
    	setErrorMsg("Please choose an aircraft first");
    	return ERROR;
    }
    int userId = (Integer)session.get("userId");
    double cost = airportService.getAirport(airportToBuy).getCost();
    double money = userService.getUserMoney(userId);
    if(money<cost){
		setErrorMsg("Not enough money to buy this aircraft.");
		return ERROR;
	}
	money -= cost;
	userService.updateUserMoney(userId, money);
	session.put("money", money);
    List<Airport> list = airportService.buyAirport(userId,airportToBuy);
    if(list == null){
    	setErrorMsg("Each user could only own one hub");
    	return ERROR;
    }
    setUserAirport(list);
	return SUCCESS;
}

public AirportService getAirportService() {
	return airportService;
}

public void setAirportService(AirportService airportService) {
	this.airportService = airportService;
}

public String getDistance() {
	return distance;
}

public void setDistance(String distance) {
	this.distance = distance;
}

public String getFromAirportName() {
	return fromAirportName;
}
public void setFromAirportName(String fromAirportName) {
	this.fromAirportName = fromAirportName;
}
public String getToAirportName() {
	return toAirportName;
}
public void setToAirportName(String toAirportName) {
	this.toAirportName = toAirportName;
}
public Airport getFromAirport() {
	return fromAirport;
}
public void setFromAirport(Airport fromAirport) {
	this.fromAirport = fromAirport;
}
public Airport getToAirport() {
	return toAirport;
}
public void setToAirport(Airport toAirport) {
	this.toAirport = toAirport;
}
public String getErrorMsg() {
	return errorMsg;
}

public void setErrorMsg(String errorMsg) {
	this.errorMsg = errorMsg;
}

public String getAirportToBuy() {
	return airportToBuy;
}

public void setAirportToBuy(String airportToBuy) {
	this.airportToBuy = airportToBuy;
}

public List<Airport> getUserAirport() {
	return userAirport;
}

public void setUserAirport(List<Airport> userAirport) {
	this.userAirport = userAirport;
}

public UserService getUserService() {
	return userService;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}

}
