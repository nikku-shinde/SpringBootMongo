package com.example.spring_with_mongo_db.model;

public class AuthenticationResponse {
	
	private String token;

	
	
	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
