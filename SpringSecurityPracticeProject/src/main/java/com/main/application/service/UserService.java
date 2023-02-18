package com.main.application.service;

import org.springframework.stereotype.Service;

import com.main.application.entity.User;

@Service
public interface UserService {
	
	boolean checkUserExistByEmail(String email,long id);
	
	boolean checkUserExistByMobileNumber(String email,long id);
	
	User saveUser(User user); 
}
