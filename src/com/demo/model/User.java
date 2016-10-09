package com.demo.model;

public class User {
	private int id;
	private String name;
	private String password;
	private boolean superuser;
	private String osudotnum;
	
	//
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
	//
	
	public String getOsudotnum(){
		return osudotnum;
	}
	
	public void setOsudotnum(String osudotnum){
		this.osudotnum = osudotnum;
	}
	
	//
	
	public boolean getSuperuser(){
		return superuser;
	}

	public void setSuperuser(boolean superuser){
		this.superuser = superuser;
	}
	
	

}
