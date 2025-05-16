package com.student.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.model.Admin;

public interface AdminRepositary extends JpaRepository<Admin, Integer>{
	
	Admin findByName(String name);

}
