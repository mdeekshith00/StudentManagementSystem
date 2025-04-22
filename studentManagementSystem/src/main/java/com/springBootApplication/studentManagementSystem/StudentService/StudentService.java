package com.springBootApplication.studentManagementSystem.StudentService;

import java.util.List;
import com.springBootApplication.studentManagementSystem.Student.Student;


public interface StudentService {
	
	Student addStudent(Student s);
	List<Student> getAllStudent();
	Student getStudentById(int id);
	void deleteStudentById(int id);
	String updateStudent(Student s , int id);
	Student findStudentByName(String name);
	Student findStudentByRollNo(int rollNo);

}
