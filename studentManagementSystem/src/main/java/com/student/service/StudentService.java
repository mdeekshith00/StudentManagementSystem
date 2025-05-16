package com.student.service;

import java.util.List;

import com.student.model.Student;


public interface StudentService {
	
	Student addStudent(Student s);
	List<Student> getAllStudent();
	Student getStudentById(int id);
	void deleteStudentById(int id);
	String updateStudent(Student s , int id);
	 List<Student> findStudentByName(String name);
	 List<Student> findStudentByRollNo(int rollNo);

}
