package com.example.spring_with_mongo_db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subTopic")
public class SubTopic {

	@Id
	private Integer id;
	private String subTopicName;

	@DBRef
	private Topic topic;

	public SubTopic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubTopic(Integer id, String subTopicName, Topic topic) {
		super();
		this.id = id;
		this.subTopicName = subTopicName;
		this.topic = topic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubTopicName() {
		return subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
