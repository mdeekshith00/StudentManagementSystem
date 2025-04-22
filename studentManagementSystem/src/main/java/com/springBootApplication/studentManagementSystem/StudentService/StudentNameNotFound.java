package com.springBootApplication.studentManagementSystem.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNameNotFound extends RuntimeException {
	
	public StudentNameNotFound(String message) {
		super(message);
		
	}

}
