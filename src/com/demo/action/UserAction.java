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

	
	public String deleteUser(){
		Map session = ActionContext.getContext().getSession();
	    if(session.get("logined")==null){
	    	setErrorMsg("Please sign in first");
	    	return ERROR;
	    }
	    if(usernameToDelete==null || usernameToDelete.isEmpty() ){
	    	setErrorMsg("Please choose an aircraft to delete");
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
		if(session.get("logined")==null){
		    	setErrorMsg("Please sign in first");
		    	return ERROR;
		   }
		if(usernameToUpdate==null || usernameToUpdate.isEmpty() ){
	    	setErrorMsg("Please choose an aircraft to delete");
	    	return ERROR;
	    }
		//check that username and dot number arent in use
		List<User> allUsers = userService.getAllUsers();
		for(User u: allUsers){
			if(u.getName().equals(userName)) setErrorMsg("Please choose a name not in use."); return ERROR;
		}
		for(User u: allUsers){
			if(u.getOsudotnum().equals(osuDotnum)) setErrorMsg("Please choose an OSU dot number not in use."); return ERROR;
		}
		//update appropriate user information
		for(User u: allUsers){
	    	if(u.getName().equals(usernameToUpdate)){
	    		userToUpdate = u;
	    		u.setName(userName);
	    		u.setPassword(passWord);
	    		u.setOsudotnum(osuDotnum);
	    		break;
	    	}
	    }
		setAllUsers(allUsers);
		setUserName(usernameToUpdate);
		setPassWord(passWord);
		setOsuDotnum(osuDotnum);
		
		userService.updateUsername(userToUpdate.getId(),usernameToUpdate);
		userService.updatePassword(userToUpdate.getId(),passWord);
		userService.updateUserOsudotnumber(userToUpdate.getId(),osuDotnum);
		
		
		
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
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
