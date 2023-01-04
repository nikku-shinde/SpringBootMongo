package com.example.spring_with_mongo_db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_with_mongo_db.model.SubTopic;

@Repository
public interface SubTopicRepository extends MongoRepository<SubTopic, Integer> {

}
