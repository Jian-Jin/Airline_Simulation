package com.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.model.User;
import com.demo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
  private UserService userService;
  private List<User> users;
  private List<String> names;
  private String errorMsg;
  
public String getUser(){
	if(users==null){
		users =  userService.getUser();
        names = new ArrayList<String>();
        for(User p : users){
        	names.add(p.getName());
        }
	}
	return SUCCESS;
}

//

public UserService getUserService() {
	return userService;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}

//

public List<User> getUsers(){
	return users;
}

public void setUsers(List<User> users) {
	this.users = users;
}

//

public List<String> getNames() {
	return names;
}

public void setNames(List<String> names) {
	this.names = names;
}

//

public String getErrorMsg() {
	return errorMsg;
}

public void setErrorMsg(String errorMsg) {
	this.errorMsg = errorMsg;
}

  
}
