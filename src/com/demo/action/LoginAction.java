package com.demo.action;
import com.demo.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String passWord;
	private LoginService loginService;

	@Override
	public String execute() throws Exception {
		 
        // a simple check
		if(loginService.checkLogin(userName, passWord)){
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
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}