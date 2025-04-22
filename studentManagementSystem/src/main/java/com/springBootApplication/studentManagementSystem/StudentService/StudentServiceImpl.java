package com.springBootApplication.studentManagementSystem.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootApplication.studentManagementSystem.Student.Student;
import com.springBootApplication.studentManagementSystem.StudentRepositary.StudentRepositary;


@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepositary repositary;
	
	public StudentServiceImpl(StudentRepositary repositary) {
		super();
		this.repositary = repositary;
	}

	@Override
	public Student addStudent(Student s) {
		// TODO Auto-generated method stub
		Student S = repositary.save(s);
		return s;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repositary.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Optional<Student> student =  repositary.findById(id);
		if(student.isEmpty()) {
			throw new StudentDetailsNotFound("student id not found here ");
		}
		return student.get();
	}
	

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		repositary.deleteById(id);
	}

	@Override
	public String updateStudent(Student s, int id) {
		// TODO Auto-generated method stub
		Student student = repositary.findById(id).get();
		if(student == null) {
			throw new StudentDetailsNotFound("student id not found here ");
		}
		student.setName(s.getName());
		student.setRollno(s.getRollNo());
		student.setDob(s.getDob());
		student.setAddress(s.getAddress());
		
		repositary.save(student);
		return "Updated Studenty deatils ";
	}

	public Student findStudentByName(String name) {
		// TODO Auto-generated method stub
		Student s = repositary.findStudentByName(name);
		if(s == null) {
			throw new StudentNameNotFound("Student Name Not Found Here");
		}
		return s;
	
	}

	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		return repositary.findStudentByRollNo(rollNo);
	}

}
