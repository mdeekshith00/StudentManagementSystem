package com.springBootApplication.studentManagementSystem.StudentRepositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootApplication.studentManagementSystem.Student.Student;

@Repository
public interface StudentRepositary extends JpaRepository<Student,Integer>{



}
