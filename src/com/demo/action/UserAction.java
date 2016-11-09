package com.demo.action;

import com.demo.service.UserService;

import java.util.List;
import java.util.Map;

import com.demo.model.User;
import com.demo.service.RegisterService;
import com.demo.service.AircraftService;
import com.demo.service.AirportService;
import com.demo.service.RouteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport  {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String passWord;
	private String osuDotnum;
	private String moneyInput;
	private List<User> allUsers;
	private User userToDelete;
	private User userToUpdate;
	private boolean superUser;
	private String usernameToDelete;
	private String usernameToUpdate;
	private RegisterService registerService;
	private UserService userService;
	private AircraftService aircraftService;
	private AirportService airportService;
	private RouteService routeService;
	private String errorMsg;
	
	public String register(){
		if(registerService.register(userName, passWord, osuDotnum, superUser))
			return SUCCESS;
		else{
			setErrorMsg("Register failed, this username has been registered!");
			return ERROR;
		}
	}
	
	public String viewUser(){
		Map session = ActionContext.getContext().getSession();
		
		if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(usernameToUpdate==null || usernameToUpdate.isEmpty() ){
	    	setErrorMsg("Please choose an user to update");
	    	return ERROR;
	    }
	    List<User> allUsers = userService.getAllUsers();
	    for(User u : allUsers){
	    	if(u.getName().equals(usernameToUpdate)){
	    		userToUpdate = u;
	    		break;
	    	}
	    }
	    setUserToUpdate(userToUpdate);
	    session.put("userToUpdateId", userToUpdate.getId());
		
		return SUCCESS;
		
		
		
	}
	
	public String deleteUser(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(usernameToDelete==null || usernameToDelete.isEmpty() ){
	    	setErrorMsg("Please choose an user to delete");
	    	return ERROR;
	    }
		List<User> allUsers = userService.getAllUsers();
		allUsers.remove(userToDelete);
	    for(User u : allUsers){
	    	if(u.getName().equals(usernameToDelete)){
	    		userToDelete = u;
	    		allUsers.remove(userToDelete);
	    		break;
	    	}
	    }
	    int userId = userToDelete.getId();
	    
	    routeService.deleteUserRoute(userId);
	    aircraftService.deleteAllUserAircraft(userId);
	    airportService.deleteUserAirport(userId);
	    userService.deleteUser(userId);
	    
	    setAllUsers(allUsers);
		return SUCCESS;
	}
	
	public String setPassword() {
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(passWord==null || passWord.isEmpty() ){
	    	setErrorMsg("Please enter your osu dot number");
	    	return ERROR;
	    }
	    int userId = (Integer) session.get("userToUpdateId");
	    userService.updatePassword(userId, passWord);
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	
	
	public String setUsername(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(userName==null || userName.isEmpty() ){
	    	setErrorMsg("Please enter your osu dot number");
	    	return ERROR;
	    }
	    int userId = (Integer) session.get("userToUpdateId");
	    userService.updateUsername(userId, userName);
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	
	
	public String setOsudotnum(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(osuDotnum==null || osuDotnum.isEmpty() ){
	    	setErrorMsg("Please enter your osu dot number");
	    	return ERROR;
	    }
	    int userId = (Integer) session.get("userToUpdateId");
	    userService.updateUserOsudotnumber(userId, osuDotnum);
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	    
	}
	
	
	public String setMoney(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(moneyInput==null || moneyInput.isEmpty() ){
	    	setErrorMsg("Please enter your osu dot number");
	    	return ERROR;
	    }
	    int userId = (Integer) session.get("userToUpdateId");
	    double money = Double.parseDouble(moneyInput);
	    userService.updateUserMoney(userId, money);
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	
	public String updateUsername(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userToUpdateId");
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	public String updatePassword(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userToUpdateId");
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	public String updateOsudotnum(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userToUpdateId");
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	public String updateMoney(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userToUpdateId");
	    User userToUpdate = userService.getUserById(userId);
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	
	
	public List<User> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsernameToDelete(){
		return usernameToDelete;
	}
	
	public void setUsernameToDelete(String usernameToDelete){
		this.usernameToDelete = usernameToDelete;
	}
	//
	public String getUsernameToUpdate(){
		return usernameToUpdate;
	}
	
	public void setUsernameToUpdate(String usernameToUpdate){
		this.usernameToUpdate = usernameToUpdate;
	}
	//
	public User getUserToUpdate(){
		return userToUpdate;
	}
	
	public void setUserToUpdate(User userToUpdate){
		this.userToUpdate = userToUpdate;
	}
	//
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	//
	public String getMoneyInput() {
		return moneyInput;
	}

	public void setMoneyInput(String moneyInput) {
		this.moneyInput = moneyInput;
	}
	
	//
	
	public String getOsuDotNum(){
		return osuDotnum;
	}
	
	public void setOsuDotnum(String osuDotnum){
		this.osuDotnum = osuDotnum;
	}
	
	
	//
	
	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

//
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public RouteService getRouteService() {
		return routeService;
	}

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
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
	//
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	//
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
