package com.demo.action;

import com.demo.service.UserService;

import java.util.List;
import java.util.Map;

import com.demo.model.User;
import com.demo.service.RegisterService;
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
	    for(User u : allUsers){
	    	if(u.getName().equals(usernameToDelete)){
	    		userToDelete = u;
	    		allUsers.remove(userToDelete);
	    		break;
	    	}
	    }
	    
	    setAllUsers(allUsers);
	    userService.deleteUser(id);
	    
		return SUCCESS;
	}
	
	public String updateUser(){
		
		//check login and name to update are not null
		Map session = ActionContext.getContext().getSession();
		userToUpdate = getUserToUpdate();
		if(session.get("logined")==null){
		    	setErrorMsg("Please sign in first");
		    	return ERROR;
		   }
		if(userToUpdate==null){
	    	setErrorMsg("User to update not found.");
	    	return ERROR;
	    }
		//check that username and dot number arent in use
		List<User> allUsers = userService.getAllUsers();
		allUsers.remove(userToUpdate);
		for(User u: allUsers){
			if(u.getName().equals(userName)) setErrorMsg("Please choose a name not in use."); return ERROR;
		}
		for(User u: allUsers){
			if(u.getOsudotnum().equals(osuDotnum)) setErrorMsg("Please choose an OSU dot number not in use."); return ERROR;
		}
		//update appropriate user information
		
		if(!userToUpdate.getName().equals(userName)){
			userToUpdate.setName(userName);
			userService.updateUsername(userToUpdate.getId(),userName);
		}
		if(!userToUpdate.getPassword().equals(passWord)){
			userToUpdate.setPassword(passWord);
			userService.updatePassword(userToUpdate.getId(),passWord);
		}
		if(!userToUpdate.getOsudotnum().equals(osuDotnum)){
			userToUpdate.setOsudotnum(osuDotnum);
			userService.updateUserOsudotnumber(userToUpdate.getId(),osuDotnum);
		}		
		if(!userToUpdate.getMoney().equals(moneyInput)){
			userToUpdate.setMoney(Double.parseDouble(moneyInput));
			userService.updateUserMoney(userToUpdate.getId(), Double.parseDouble(moneyInput));
		}
		
		allUsers.add(userToUpdate);
		
		
		
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
		this.passWord = moneyInput;
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
