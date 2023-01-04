package com.example.spring_with_mongo_db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "topic")
public class Topic {

	@Id
	private Integer id;
	private String topicName;

	@DBRef
	private Course course;

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(Integer id, String topicName, Course course) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.course = course;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
