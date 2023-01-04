package com.example.spring_with_mongo_db.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring_with_mongo_db.model.Course;
import com.example.spring_with_mongo_db.model.Question;
import com.example.spring_with_mongo_db.model.Student;
import com.example.spring_with_mongo_db.model.SubTopic;
import com.example.spring_with_mongo_db.model.Topic;
import com.example.spring_with_mongo_db.model.UserModel;
import com.example.spring_with_mongo_db.repository.CourseRepository;
import com.example.spring_with_mongo_db.repository.QuestionRepository;
import com.example.spring_with_mongo_db.repository.RoleRepository;
import com.example.spring_with_mongo_db.repository.StudentRepository;
import com.example.spring_with_mongo_db.repository.SubTopicRepository;
import com.example.spring_with_mongo_db.repository.TopicRepository;
import com.example.spring_with_mongo_db.repository.UserRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private TopicRepository topicRepo;
	
	@Autowired
	private SubTopicRepository subTopicRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public Student addStudent(Student student) {
		return this.studentRepo.save(student);
	}

	@Override
	public List<Student> getStudent() {
		return this.studentRepo.findAll();
	}

	@Override
	public UserModel addUser(UserModel user) {
		return this.userRepo.save(user);
	}

	@Override
	public Course addCourse(Course course) {
		return this.courseRepo.save(course);
	}

	@Override
	public Topic addTopic(Topic topic) {
		return this.topicRepo.save(topic);
	}

	@Override
	public List<Topic> getAllTopics() {
		return this.topicRepo.findAll();
	}
	
	@Override
	public SubTopic addSubTopic(SubTopic subTopic) {
		return this.subTopicRepo.save(subTopic);
	}

	@Override
	public List<SubTopic> getAllSubTopics() {
		return this.subTopicRepo.findAll();
	}

	@Override
	public Question addQuestion(Question question) {
		return this.questionRepo.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		return this.questionRepo.findAll();
	}

	@Override
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("C:\\demo\\"+file.getOriginalFilename()));
	}
	

}
