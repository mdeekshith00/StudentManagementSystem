package com.springBootApplication.studentManagementSystem.StudentRepositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootApplication.studentManagementSystem.Student.Student;

@Repository
public interface StudentRepositary extends JpaRepository<Student,Integer>{
	Student findStudentByName(String name);
	Student findStudentByRollNo(int rollNo);



}
