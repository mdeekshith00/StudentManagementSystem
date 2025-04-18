package com.springBootApplication.studentManagementSystem.Student;

import java.util.List;
import java.util.Optional;

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


import jakarta.validation.Valid;

@RestController
@RequestMapping("/Students")
public class StudentController {
	
	private StudentRepositary repositary;
	
	// constructor injection 
	public StudentController(StudentRepositary repositary) {
		this.repositary=repositary;
	}

	public StudentRepositary getRepositary() {
		return repositary;
	}

	public void setRepositary(StudentRepositary repositary) {
		this.repositary = repositary;
	}
	
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody @Valid  Student student) {
		return new ResponseEntity<Student>(repositary.save(student), HttpStatus.CREATED);
		
	}
	@GetMapping("/get")
	public List<Student> getAllStudents() {
		return repositary.findAll();
	}
	@GetMapping("/getBy/{id}")
	public Optional<Student> getStudentById(@Valid  @PathVariable int id) {
		Optional<Student> s = repositary.findById(id);
		if(s == null) {
			throw new StudentDetailsNotFound("message");
		}
		return s;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@Valid  @PathVariable int id) {
		repositary.deleteById(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent( @PathVariable int id ,@Valid  @RequestBody Student student) {
		Student st = repositary.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Student is not exists with given data :" + id));
	
		st.setName(st.getName());
		st.setRollno(st.getRollNo());
		st.setDob(st.getDob());
		st.setAddress(st.getAddress());
		repositary.save(st);
		
		return st;
	}
	


}
