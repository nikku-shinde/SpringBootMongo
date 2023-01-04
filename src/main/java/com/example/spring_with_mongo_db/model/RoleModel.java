package com.example.spring_with_mongo_db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class RoleModel {

	@Id
	private Integer id;
	private String role;

	public RoleModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleModel(Integer id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
