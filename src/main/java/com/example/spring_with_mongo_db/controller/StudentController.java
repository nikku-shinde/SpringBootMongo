package com.example.spring_with_mongo_db.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring_with_mongo_db.config.CustomUserDetailsService;
import com.example.spring_with_mongo_db.config.JwtUtil;
import com.example.spring_with_mongo_db.model.AuthenticationResponse;
import com.example.spring_with_mongo_db.model.Course;
import com.example.spring_with_mongo_db.model.Question;
import com.example.spring_with_mongo_db.model.RoleModel;
import com.example.spring_with_mongo_db.model.Student;
import com.example.spring_with_mongo_db.model.SubTopic;
import com.example.spring_with_mongo_db.model.Topic;
import com.example.spring_with_mongo_db.model.UserModel;
import com.example.spring_with_mongo_db.payload.LoginPayload;
import com.example.spring_with_mongo_db.repository.RoleRepository;
import com.example.spring_with_mongo_db.repository.StudentRepository;
import com.example.spring_with_mongo_db.repository.UserRepository;
import com.example.spring_with_mongo_db.service.StudentService;

@RestController
@RequestMapping("/users")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add-student")
	public Student addStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student);
	}
	
	@GetMapping("/get-students")
	public List<Student> getStudent() {
		return this.studentService.getStudent();
	}
	
	@GetMapping("/findByName/{name}")
	public Student getStudentByName(@PathVariable("name") String name) {
		Student std = this.studentRepo.findByName(name);
		System.out.println(std.getName());
		return std;
	}
	
	@GetMapping("/findByCity/{city}")
	public List<Student> getStudentsByCity(@PathVariable("city") String city) {
		List<Student> std = this.studentRepo.findCustomByCity(city);
		for(Student s : std) {
			System.out.println(s.getName());
		}
		return std;
	}
	
	@PostMapping("/add-user")
	public UserModel addUser(@RequestBody UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return this.studentService.addUser(user);
	}
	
	@PostMapping("/add-role")
	public RoleModel addRole(@RequestBody RoleModel role) {
		return this.roleRepo.save(role);
	}
	
	@GetMapping("/findByUserName/{userName}")
	public UserModel getUserByUserName(@PathVariable("userName") String userName) {
		return this.userRepo.findByUserName(userName);
	}
	
	@PostMapping("/add-course")
	public Course addCourse(@RequestBody Course course) {
		return this.studentService.addCourse(course);
	}
	
	@PostMapping("/add-topic")
	public Topic addTopic(@RequestBody Topic topic) {
		return this.studentService.addTopic(topic);
	}
	
	@GetMapping("/getAllTopics")
	public List<Topic> getAllTopics() {
		return this.studentService.getAllTopics();
	}
	
	@PostMapping("/add-subTopic")
	public SubTopic addSubTopic(@RequestBody SubTopic subTopic) {
		return this.studentService.addSubTopic(subTopic);
	}
	
	@GetMapping("/getAllSubTopics")
	public List<SubTopic> getAllSubTopics() {
		return this.studentService.getAllSubTopics();
	}
	
	@PostMapping("/add-question")
	public Question addQuestion(@RequestBody Question question) {
		return this.studentService.addQuestion(question);
	}
	
	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions() {
		return this.studentService.getAllQuestions();
	}
	
	@PostMapping("/fileUpload")
	public void fileUpload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		this.studentService.fileUpload(file); 
		
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginPayload loginPayload) throws Exception {
		UserModel user = null;
		try {
			user = this.userRepo.findByUserName(loginPayload.getUserName());
			System.out.println(user);
			if (passwordEncoder.matches(loginPayload.getPassword(), user.getPassword())) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(loginPayload.getUserName());
				System.out.println("authority : " + userDetails.getAuthorities());
				System.out.println(userDetails.getAuthorities());

				String token = jwtUtil.generateToken(userDetails);
				System.out.println(token);
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginPayload.getUserName(),
						loginPayload.getPassword()));
				return ResponseEntity.ok(new AuthenticationResponse(token));
			} else {
				return ResponseEntity.ok(new String("Password Invalid"));
			}

		} catch (DisabledException e) {
			throw new Exception("User Disabled", e);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials", e);
		} catch (NullPointerException e) {
			System.out.println("exception" + user);
			return ResponseEntity.ok(new String("User Invalid"));
		}
	}

}
