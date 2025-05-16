 package com.student.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface StudentRepositary extends JpaRepository<Student,Integer>{
	 List<Student> findStudentByName(String name);
	 List<Student> findStudentByRollNo(int rollNo);



}
