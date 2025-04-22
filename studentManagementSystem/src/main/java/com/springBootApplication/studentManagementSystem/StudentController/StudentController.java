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
	public Student addStudent(@Valid @RequestBody Student s) {
		return service.addStudent(s);
	}
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
	    return 	service.getAllStudent();
	}
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);
	}
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@Valid @RequestBody Student s ,@PathVariable  int id) {
		service.updateStudent(s, id);
		return "student details updated";
	}

}
	
