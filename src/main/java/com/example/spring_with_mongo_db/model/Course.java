package com.example.spring_with_mongo_db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course")
public class Course {
	
	@Id
	private Integer id;
	private String courseName;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Integer id, String courseName) {
		super();
		this.id = id;
		this.courseName = courseName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
