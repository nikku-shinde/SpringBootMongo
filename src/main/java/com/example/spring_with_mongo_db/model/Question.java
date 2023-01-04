package com.example.spring_with_mongo_db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
public class Question {

	@Id
	private Integer id;
	private String question;

	@DBRef
	private SubTopic subTopic;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Integer id, String question, SubTopic subTopic) {
		super();
		this.id = id;
		this.question = question;
		this.subTopic = subTopic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public SubTopic getSubTopic() {
		return subTopic;
	}

	public void setSubTopic(SubTopic subTopic) {
		this.subTopic = subTopic;
	}

}
