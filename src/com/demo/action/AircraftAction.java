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
  private String planeCustomizeName;
  private String firstClassRatio;
  private String businessClassRatio;
  
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

public String customizePlane(){
	Map session = ActionContext.getContext().getSession();
	String aircraftToBuy = (String)session.get("aircraftToBuy");
	
	Aircraft plane = aircraftService.getPlaneByName(aircraftToBuy).get(0);
	
    int userId = (Integer)session.get("userId");

	List<Aircraft> ownedAircrafts = aircraftService.getUserPlanes(userId);
	for(Aircraft a : ownedAircrafts){
		if(a.getCustomizedName().equals(planeCustomizeName)){
			setErrorMsg("this plane name already exists,pls try again");
			return ERROR;
		}
	}
	if(firstClassRatio==null || firstClassRatio.isEmpty()||businessClassRatio==null||businessClassRatio.isEmpty()){
		setErrorMsg("Please input a valid value of firstClassRatio and businessClassRatio ");
		return ERROR;
	}
	try{
	double d1 = Double.valueOf(firstClassRatio);
	double d2 = Double.valueOf(businessClassRatio);
	if(d1>=0 && d2>=0 && d1+d2<=100){
		  List<Aircraft> list = aircraftService.buyPlane(userId,plane.getId(),planeCustomizeName, d1, d2);
		  setUserPlanes(list);
		  return SUCCESS;
	}else{
		setErrorMsg("Please input a valid value of firstClassRatio and businessClassRatio ");
		return ERROR;
	}
	}catch(Exception e){
		setErrorMsg("Please input a valid value of firstClassRatio and businessClassRatio ");
		return ERROR;
	}

	

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
    session.put("aircraftToBuy", aircraftToBuy);
	setAircraftToBuy(aircraftToBuy);

    return SUCCESS;

//	return SUCCESS;
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

public String getPlaneCustomizeName() {
	return planeCustomizeName;
}

public void setPlaneCustomizeName(String planeCustomizeName) {
	this.planeCustomizeName = planeCustomizeName;
}

public String getFirstClassRatio() {
	return firstClassRatio;
}

public void setFirstClassRatio(String firstClassRatio) {
	this.firstClassRatio = firstClassRatio;
}

public String getBusinessClassRatio() {
	return businessClassRatio;
}

public void setBusinessClassRatio(String businessClassRatio) {
	this.businessClassRatio = businessClassRatio;
}


  
}
