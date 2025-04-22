package com.springBootApplication.studentManagementSystem.StudentController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootApplication.studentManagementSystem.Student.Student;
import com.springBootApplication.studentManagementSystem.StudentService.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Students")
public class StudentController {
	@Autowired
	private StudentServiceImpl service;
	
	// constructor injection 
	public StudentController(StudentServiceImpl service) {
		this.service=service;
	}
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student s) {
		return new ResponseEntity<>(service.addStudent(s),HttpStatus.OK);
	}
	@GetMapping(path = "/getAllStudent", headers = "X-API-VERSION=1")
	public ResponseEntity<List<Student>> getAllStudent(){
	    return 	new ResponseEntity<>(service.getAllStudent(),HttpStatus.OK);
	}
	@GetMapping(path = "/getAllStudent", params = "version=1")
	public ResponseEntity<List<Student>> getAllStudentversioning(){
	    return 	new ResponseEntity<>(service.getAllStudent(),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);
		return new  ResponseEntity<>("DELETED STUDENT DETAILS ON THIS ID :" + id  , HttpStatus.OK);
	}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<String> updateStudent(@Valid @RequestBody Student s ,@PathVariable  int id) {
		service.updateStudent(s, id);
		return new ResponseEntity<>("Student details updated", HttpStatus.OK);
	}
	@GetMapping("/getStudentByName/{name}")
	public ResponseEntity<Student> getStudentById(@PathVariable String name) {
		return new ResponseEntity<>(service.findStudentByName(name),HttpStatus.OK);
	}
	@GetMapping("/getStudentByRollNo/{rollNo}")
	public ResponseEntity<Student> getStudentByRollNo(@PathVariable int rollNo) {
		Student s = service.findStudentByRollNo(rollNo);
		if(s != null) {
		return new ResponseEntity<>(s,HttpStatus.OK);
	}  
		return new ResponseEntity<>(s,HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
	    Student student1= 	service.getStudentById(id);
	    if(student1 != null) {
	    return new ResponseEntity<>(student1,HttpStatus.OK);
	    } 
	    return new ResponseEntity<>(student1, HttpStatus.NOT_FOUND);
	}

}
	
