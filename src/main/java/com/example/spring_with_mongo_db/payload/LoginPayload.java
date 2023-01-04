package com.example.spring_with_mongo_db.payload;


public class LoginPayload {
	private String userName;
	private String password;
	
	
	public LoginPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginPayload(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
