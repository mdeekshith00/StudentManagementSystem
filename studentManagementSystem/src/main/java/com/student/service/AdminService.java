package com.student.service;

import com.student.model.Admin;

public interface AdminService {
	Admin add(Admin admin);
	Admin getById(int id);
	String deleteById(int id);

}
