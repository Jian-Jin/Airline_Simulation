package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * @date 2014-12-03
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String userName;
	private String passWord;
	private UserDAO userDAO;

	@Override
	public String execute() throws Exception {
		 
        // a simple check
		if(userDAO.checkLogin(userName, passWord)){
			return SUCCESS;
		}else{
			return ERROR;
		}
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

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}