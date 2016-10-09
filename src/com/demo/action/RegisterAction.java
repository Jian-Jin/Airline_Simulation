package com.demo.action;

import com.demo.service.RegisterService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport  {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private String osuDotnum;
	private boolean superUser;
	private RegisterService registerService;
	private String errorMsg;
	
	public String register(){
		if(registerService.register(userName, passWord, osuDotnum, superUser))
			return SUCCESS;
		else{
			setErrorMsg("Register failed, this username has been registered!");
			return ERROR;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	//
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
