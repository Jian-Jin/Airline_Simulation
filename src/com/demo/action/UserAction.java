package com.demo.action;

import com.demo.service.UserService;
import com.demo.service.Utils;
import com.demo.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;

import com.demo.DAO.UserProfitDAO;
import com.demo.model.User;
import com.demo.service.RegisterService;
import com.demo.service.AircraftService;
import com.demo.service.AirportService;
import com.demo.service.RouteService;
import com.demo.service.SimulateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport  {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String passWord;
	private String osuDotnum;
	private String moneyInput;
	private String millions;
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
	private Utils utils;
	private String errorMsg;
	private SimulateService simulateService;
	private User adminUser;
	private String adminPassword;

	
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
		if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	
	//manage users to admin page action
	public String adminPage(){
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
	
	// change the admin password
	// In the future there should be some backup way to 
	// recover the password or reset to something
		public String adminPasswordChange(){
			Map session = ActionContext.getContext().getSession();
			User adminUser = userService.getUser(userName, passWord);	
			String changedPassword="";
			if(session.get("logined")==null){
		    	setErrorMsg("Please sign in first");
		    	return ERROR;
		    }
			if(session.get("superuser")==null){
		    	setErrorMsg("Please sign in as admin");
		    	return ERROR;
			}	   
							
			if(adminPassword==null || adminPassword.isEmpty() ){
		    	setErrorMsg("Please enter a valid password to change to");
		    	return ERROR;
		    }				
		
			//currently hardcoded "admin" name instead
			// of getting the name of the session
			int userId = userService.getIdbyName("admin");			
			userService.updatePassword(userId, adminPassword);
			changedPassword=adminPassword;		
			
			return SUCCESS;
		}
		
		// Manage Users page to Delete Class page
		public String goToDeleteClass(){
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
		
		//Removes all users from database who are not superusers
		public String deleteClass(){
			Map session = ActionContext.getContext().getSession();			
			if(session.get("logined")==null){
		    	setErrorMsg("Please sign in first");
		    	return ERROR;
		    }
			if(session.get("superuser")==null){
		    	setErrorMsg("Please sign in as admin");
		    	return ERROR;
			}	   		
			
			userService.deleteClass();
			
			return SUCCESS;
		}
	
	public String resetUser(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
	    	return ERROR;
	    }
	    int userId = (Integer)session.get("userToUpdateId");
	    User userToUpdate = userService.getUserById(userId);
	    
	    
	    
	    double t = 600000000;
	    
	    userService.updateUserMoney(userId,t);
	    routeService.deleteUserRoute(userId);
	    aircraftService.deleteAllUserAircraft(userId);
	    airportService.deleteUserAirport(userId);
	    simulateService.deleteUserProfit(userId);
	    
	    userToUpdate.setMoney(t);
	    userToUpdate.setMoneyString(utils.convertToMillion(t));
	    
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	
	public String deleteUser(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	    
	    allUsers.remove(userToDelete);
	    int userId = userToDelete.getId();
	    
	    routeService.deleteUserRoute(userId);
	    aircraftService.deleteAllUserAircraft(userId);
	    airportService.deleteUserAirport(userId);
	    userService.deleteUser(userId);
	    simulateService.deleteUserProfit(userId);
	    
	    setAllUsers(allUsers);
		return SUCCESS;
	}
	
	public String setPassword() {
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
	    	return ERROR;
	    }
	    if(moneyInput==null || moneyInput.isEmpty() ){
	    	setErrorMsg("Please enter your osu dot number");
	    	return ERROR;
	    }
	    int userId = (Integer) session.get("userToUpdateId");
	    User userToUpdate = userService.getUserById(userId);
	    
	    double money = Double.parseDouble(moneyInput);
	    userService.updateUserMoney(userId, money);
	    userToUpdate.setMoney(money);
	    userToUpdate.setMoneyString(utils.convertToMillion(money));
	    
	    
	    
	    setUserToUpdate(userToUpdate);
	    return SUCCESS;
	}
	
	public String updateUsername(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	    if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
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
	
	public String getMillions(){
		return millions;
	}
	
	public void setMillions(String millions){
		this.millions = millions;
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
	
	public Utils getUtils(){
		return utils;
	}
	
	public void setUtils(Utils utils){
		this.utils = utils;
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
	
	public SimulateService getSimulateService() {
		return simulateService;
	}

	public void setSimulateService(SimulateService simulateService) {
		this.simulateService = simulateService;
	}
	
	public User getAdminUser(){
		return adminUser;
	}
	
	public void setAdminUser(User adminUser){
		this.adminUser=adminUser;
	}
	
	public String getAdminPassword(){
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword){
		this.adminPassword=adminPassword;
	}
	
}
