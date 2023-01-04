package com.example.spring_with_mongo_db.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring_with_mongo_db.model.Course;
import com.example.spring_with_mongo_db.model.Question;
import com.example.spring_with_mongo_db.model.Student;
import com.example.spring_with_mongo_db.model.SubTopic;
import com.example.spring_with_mongo_db.model.Topic;
import com.example.spring_with_mongo_db.model.UserModel;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> getStudent();
	
	public UserModel addUser(UserModel user);
	
	public Course addCourse(Course course);
	
	public Topic addTopic(Topic topic);
	
	public List<Topic> getAllTopics();
	
	public SubTopic addSubTopic(SubTopic subTopic);
	
	public List<SubTopic> getAllSubTopics();
	
	public Question addQuestion(Question question);
	
	public List<Question> getAllQuestions();
	
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException;

}
