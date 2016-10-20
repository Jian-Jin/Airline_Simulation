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
	private int newUserCount;
	//Below are simulation variable
	private double fuelPrice;
	private double seatPrice;
	private SimulateService simulateService;
	List<UserProfit> profits;
	private String simulateRunTime;

	public String userLogin() throws Exception {
		User user = userService.getUser(userName, passWord);
        // a simple check
		if(user != null){
			Map session = ActionContext.getContext().getSession();
			session.put("logined","true");
			session.put("userId", user.getId());
			return SUCCESS;
		}else{
			setErrorMsg("Log in failed, please try again");
			return ERROR;
		}
	}
	
	public String signout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	
	public String loginAsAdmin(){
		User user = userService.getUser(userName, passWord);
        // a simple check
		if(user != null && user.getSuperuser()){
			Map session = ActionContext.getContext().getSession();
			session.put("logined","true");
			session.put("superuser","true");
			session.put("userId", user.getId());
			return manageUser();
		}else{
			setErrorMsg("Log in failed, please try again");
			return ERROR;
		}
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
		return SUCCESS;
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
		List<User> newUsers = userService.generateUser(getNewUserCount());
		setNewAddedUsers(newUsers);
		return SUCCESS;
	}
	
	public String simulateHome(){
		Map session = ActionContext.getContext().getSession();

		if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
		}
		if(session.get("superuser")==null){
	    	setErrorMsg("Please sign in as admin");
	    	return ERROR;
		}
		 setProfits(simulateService.getProfits());
		 setSimulateRunTime(simulateService.getSimulateRunTime());
		return SUCCESS;
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

	public int getNewUserCount() {
		return newUserCount;
	}

	public void setNewUserCount(int newUserCount) {
		this.newUserCount = newUserCount;
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