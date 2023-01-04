package com.example.spring_with_mongo_db.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserModel {

	@Id
	private Integer id;
	private String name;
	private String userName;
	private String password;
	private String profile;

	@DBRef
	private Set<RoleModel> roles = new HashSet<RoleModel>();

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(Integer id, String name, String userName, String password, String profile, Set<RoleModel> roles) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.profile = profile;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

}
