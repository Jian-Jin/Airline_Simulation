package com.demo.action;
import java.util.List;
import java.util.Map;

import com.demo.model.Aircraft;
import com.demo.model.Airport;
import com.demo.model.User;
import com.demo.model.UserProfit;
import com.demo.service.SimulateService;
import com.demo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String passWord;
	private UserService userService;
	private String errorMsg;
	private List<User> allUsers;
	private List<User> newAddedUsers;
	private String newUserNames;
	//Below are simulation variable
	private double fuelPrice;
	private double seatPrice;
	private SimulateService simulateService;
	List<UserProfit> profits;
	private String simulateRunTime;

	public String userLogin() throws Exception {
		User user = userService.getUser(userName, passWord);
		//admin
		if(user != null && user.getSuperuser()){
			Map session = ActionContext.getContext().getSession();
			session.clear();
			session.put("logined","true");
			session.put("superuser","true");
			session.put("userId", user.getId());
			return manageUser();
		}
		//student
		else if(user != null){
			Map session = ActionContext.getContext().getSession();
			session.clear();
			session.put("logined","true");
			session.put("userId", user.getId());
			double money = userService.getUserMoney(user.getId());
			session.put("money", money);
			return "studentsuccess";
		}else{
			setErrorMsg("Invalid Username and Password, please try again.");
			return ERROR;
		}
	}
	
	public String signout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}


	// below are actions for admin account
	// home page of manage user 
	public String manageUser(){
		Map session = ActionContext.getContext().getSession();
		 if(session.get("logined")==null){
		    	setErrorMsg("Please sign in first");
		    	return ERROR;
		  }
		 if(session.get("superuser")==null){
		    	setErrorMsg("Please sign in as admin");
		    	return ERROR;
		  }
		setAllUsers(userService.getAllUsers());
		return "adminsuccess";
	}
	
	public String generateUser(){
		Map session = ActionContext.getContext().getSession();

		if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	  }
	 if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
	    	return ERROR;
	  }
	 String names = getNewUserNames();
	 
	List<User> newUsers = userService.generateUser(names);
	if(newUsers.isEmpty()){
		 setErrorMsg("User names input is not valid, please check and input again");
	    	return ERROR;
	}
	setNewAddedUsers(newUsers);
	return SUCCESS;
	}
	

	// admin return adminsuccess
	// normal users return success
	public String simulateHome(){
		Map session = ActionContext.getContext().getSession();

		if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
		}
		
		 setProfits(simulateService.getProfits());
		 setSimulateRunTime(simulateService.getSimulateRunTime());
		 if(session.get("superuser")==null){
		    	return SUCCESS;
		}
		return "adminsuccess";
	}
	
	public String runSimulate(){
		Map session = ActionContext.getContext().getSession();

		if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	  }
	 if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
	    	return ERROR;
	  }

	 simulateService.runSimulate(getFuelPrice(), getSeatPrice());
	 setProfits(simulateService.getProfits());
	 setSimulateRunTime(simulateService.getSimulateRunTime());
	 return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public List<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}

	public List<User> getNewAddedUsers() {
		return newAddedUsers;
	}

	public void setNewAddedUsers(List<User> newAddedUsers) {
		this.newAddedUsers = newAddedUsers;
	}

	

	public String getNewUserNames() {
		return newUserNames;
	}

	public void setNewUserNames(String newUserNames) {
		this.newUserNames = newUserNames;
	}

	public double getFuelPrice() {
		return fuelPrice;
	}

	public void setFuelPrice(double fuelPrice) {
		this.fuelPrice = fuelPrice;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	public SimulateService getSimulateService() {
		return simulateService;
	}

	public void setSimulateService(SimulateService simulateService) {
		this.simulateService = simulateService;
	}

	public List<UserProfit> getProfits() {
		return profits;
	}

	public void setProfits(List<UserProfit> profits) {
		this.profits = profits;
	}

	public String getSimulateRunTime() {
		return simulateRunTime;
	}

	public void setSimulateRunTime(String simulateRunTime) {
		this.simulateRunTime = simulateRunTime;
	}
 
	
	

}