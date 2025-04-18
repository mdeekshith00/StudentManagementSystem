package com.springBootApplication.studentManagementSystem.Student;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;


@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
	private String name;
	
	@Min(value = 3, message = "rollNo should not be Greather than 3")
	@Column(unique = true)
	private Integer  rollNo;
	
	@Column
	@Past(message = " Birth Date should be in the PAst")
	private LocalDate dob;
	@Column
	private String address;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, int rollNo, @Past(message = " Birth Date should be in the PAst") LocalDate dob,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.dob = dob;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollno(int rollNo) {
		this.rollNo = rollNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + name + ", Rollno=" + rollNo + ", dob=" + dob + ", address=" + address
				+ "]";
	}
	
	

}
