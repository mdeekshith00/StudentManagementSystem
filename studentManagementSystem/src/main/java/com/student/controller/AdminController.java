package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Admin;
import com.student.service.AdminServiceImpl;

@RestController

public class AdminController {
	@Autowired
	private AdminServiceImpl adminService;
	
	@PostMapping("/")
	public String login() {
		return "Welcome to StudentManagement :";
	}
	@PostMapping("/admin")
	public ResponseEntity<Admin> admin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.add(admin) , HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getById(@PathVariable int id) {
		return new ResponseEntity<>(adminService.getById(id) , HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		return new ResponseEntity<>(adminService.deleteById(id) , HttpStatus.OK);
	}

	

}
