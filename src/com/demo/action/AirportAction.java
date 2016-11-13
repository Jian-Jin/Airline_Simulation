package com.demo.action;

import java.text.DecimalFormat;
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
  private List<Airport> allAirports;
  private double demandMult;
  private Airport demandAirport;
  
  public String airportHome(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userId");
	  if(allAirports==null){
		  setAllAirports(airportService.getAllAirport());
	  }
	  setUserAirport(airportService.getMyAirport(userId));
	  return SUCCESS;
  }
public String getAirport(){
	  fromAirport = airportService.getAirport(fromAirportName);
	  toAirport = airportService.getAirport(toAirportName);
	  System.out.println(fromAirportName);
	  System.out.println(toAirportName);

	  if(fromAirport == null){
		  setErrorMsg("Please select a departure airport");
		  return ERROR;
	  }
	  
	  if(toAirport == null){
		  setErrorMsg("Please select a destination airport");
		  return ERROR;
	  }
	  
	  DecimalFormat df = new DecimalFormat("#.00");
	  distance = df.format(airportService.distance(fromAirport, toAirport));
	  
	  return SUCCESS;	  
  }

public String manageDemand(){
	Map session = ActionContext.getContext().getSession();

	if(session.get("logined")==null){
    	setErrorMsg("Please sign in first");
    	return ERROR;
  }
 if(session.get("superuser")==null){
    	setErrorMsg("Please sign in as admin");
    	return ERROR;
  }		
	return SUCCESS;
}

public String adjustMultiplier(){
	demandAirport = airportService.getAirport(fromAirportName);
	//needed to parse next line because passing a double was causing problems
	demandMult=Double.parseDouble(toAirportName);	
	
	if(demandAirport == null || demandMult==0){
		setErrorMsg("invalid airport input or demand value");
		return ERROR;
	}
	// if here, airport is valid and demand value is valid
	// change demand value in table for airport
	//changes the multiplier that alters the demand population for each airport
	airportService.changeDemand(demandAirport.getId(), demandMult);
	
	return SUCCESS;		
}

public String buyAirport(){
	Map session = ActionContext.getContext().getSession();
    if(session.get("logined")==null){
    	setErrorMsg("Please sign in first");
    	return ERROR;
    }
    if(airportToBuy==null || airportToBuy.isEmpty()){
    	setErrorMsg("Please choose a hub to buy");
    	return ERROR;
    }
    int userId = (Integer)session.get("userId");
    double cost = airportService.getAirport(airportToBuy).getCost();
    double money = userService.getUserMoney(userId);
    if(money<cost){
		setErrorMsg("Not enough money to buy this hub.");
		return ERROR;
	}
	money -= cost;
	userService.updateUserMoney(userId, money);
	session.put("money", money);
    List<Airport> list = airportService.buyAirport(userId,airportToBuy);
    if(list == null){
    	setErrorMsg("Each user may only own one hub");
    	return ERROR;
    }
    if(allAirports==null){
		  setAllAirports(airportService.getAllAirport());
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
public List<Airport> getAllAirports() {
	return allAirports;
}
public void setAllAirports(List<Airport> allAirports) {
	this.allAirports = allAirports;
}
public double getDemandMult() {
	return demandMult;
}
public void setDemandMult(double demandMult) {
	this.demandMult = demandMult;
}
public Airport getDemandAirport() {
	return demandAirport;
}
public void setDemandAirport(Airport demandAirport) {
	this.demandAirport = demandAirport;
}

}
