package com.example.spring_with_mongo_db.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.spring_with_mongo_db.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
	
	public Student findByName(String name);
	
	
	@Query("{city:'?0'}")
    List<Student> findCustomByCity(String city);

}
