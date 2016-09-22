package com.demo.action;
import java.util.Map;

import com.demo.model.User;
import com.demo.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String passWord;
	private LoginService loginService;
	private String errorMsg;

	public String userLogin() throws Exception {
		User user = loginService.checkLogin(userName, passWord);
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
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}