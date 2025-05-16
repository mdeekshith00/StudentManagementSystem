package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.model.Admin;
import com.student.repositary.AdminRepositary;

@Service
public class AdminServiceImpl  implements  UserDetailsService ,  AdminService{
	
	@Autowired
	private AdminRepositary adminRepositary;
	
	private BCryptPasswordEncoder encoder;
	

	@Override
	public Admin add(Admin admin) {
		// TODO Auto-generated method stub
		admin.setPassword(encoder.encode(admin.getUsername()));
		return adminRepositary.save(admin);
	}

	@Override
	public Admin getById(int id) {
		// TODO Auto-generated method stub
		return adminRepositary.findById(id).get();
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		 adminRepositary.deleteById(id);
		 return " deleted Admin on this Id " + id;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return adminRepositary.findByName(username);
	}

}
