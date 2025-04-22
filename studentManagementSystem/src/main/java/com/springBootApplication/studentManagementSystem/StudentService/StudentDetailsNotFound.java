package com.springBootApplication.studentManagementSystem.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentDetailsNotFound extends RuntimeException {
	public StudentDetailsNotFound(String message) {
		super(message);
	}

}
