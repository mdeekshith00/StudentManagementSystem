package com.student.controller;

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

import com.student.model.Student;
import com.student.service.StudentServiceImpl;

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
		return new ResponseEntity<>(service.addStudent(s),HttpStatus.FOUND);
	}
	@GetMapping(path = "/getAllStudent", headers = "X-API-VERSION=1")
	public ResponseEntity<List<Student>> getAllStudent(){
	    return 	new ResponseEntity<>(service.getAllStudent(),HttpStatus.FOUND);
	}
	@GetMapping(path = "/getAllStudent", params = "version=1")
	public ResponseEntity<List<Student>> getAllStudentversioning(){
	    return 	new ResponseEntity<>(service.getAllStudent(),HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);
		return new  ResponseEntity<>(HttpStatus.FOUND);
	}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<String> updateStudent(@Valid @RequestBody Student s ,@PathVariable  int id) {
		service.updateStudent(s, id);
		return new ResponseEntity<>("Student details updated", HttpStatus.FOUND);
	}
	@GetMapping("/getStudentByName/{name}")
	public ResponseEntity<List<Student>> getStudentById(@PathVariable String name) {
		return new ResponseEntity<>(service.findStudentByName(name),HttpStatus.FOUND);
	}
	@GetMapping("/getStudentByRollNo/{rollNo}")
	public ResponseEntity<List<Student>> getStudentById(@PathVariable int rollNo) {
		return new ResponseEntity<>(service.findStudentByRollNo(rollNo),HttpStatus.OK);
	}

	@GetMapping("/getAllStudentById/{id}")
	public ResponseEntity<Student> getById(@PathVariable int id){
	    Student student1= 	service.getStudentById(id);
	    return new ResponseEntity<>(student1,HttpStatus.FOUND);
	}

}
	
