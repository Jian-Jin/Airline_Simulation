package com.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.model.Aircraft;
import com.demo.service.AircraftService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AircraftAction extends ActionSupport {
  private AircraftService aircraftService;
  private List<Aircraft> planes;
  private List<String> names;
  private List<Aircraft> userPlanes;
  private String aircraftToBuy;
  private String errorMsg;
  
public String getPlane(){
	if(planes==null){
		planes =  aircraftService.getPlane();
        names = new ArrayList<String>();
        for(Aircraft p : planes){
        	names.add(p.getName());
        }
	}
	return SUCCESS;
}

public String buyPlane(){
	Map session = ActionContext.getContext().getSession();
    if(session.get("logined")==null){
    	setErrorMsg("Please sign in first");
    	return ERROR;
    }
    if(aircraftToBuy==null || aircraftToBuy.isEmpty()){
    	setErrorMsg("Please choose an aircraft first");
    	return ERROR;
    }
    int userId = (Integer)session.get("userId");
    List<Aircraft> list = aircraftService.buyPlane(userId,aircraftToBuy);
    setUserPlanes(list);
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

public List<String> getNames() {
	return names;
}

public void setNames(List<String> names) {
	this.names = names;
}

public String getAircraftToBuy() {
	return aircraftToBuy;
}

public void setAircraftToBuy(String aircraftToBuy) {
	this.aircraftToBuy = aircraftToBuy;
}

public String getErrorMsg() {
	return errorMsg;
}

public void setErrorMsg(String errorMsg) {
	this.errorMsg = errorMsg;
}

public List<Aircraft> getUserPlanes() {
	return userPlanes;
}

public void setUserPlanes(List<Aircraft> userPlanes) {
	this.userPlanes = userPlanes;
}


  
}
