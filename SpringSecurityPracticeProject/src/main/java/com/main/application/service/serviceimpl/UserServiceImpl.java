package com.main.application.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.application.entity.User;
import com.main.application.repository.UserRepository;
import com.main.application.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public boolean checkUserExistByEmail(String email, long id) {
		// TODO Auto-generated method stub
		boolean isExist = false;
		User user = repository.getUserByEmailandId(email, id);
		if(user != null) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public boolean checkUserExistByMobileNumber(String mobileNo, long id) {
		// TODO Auto-generated method stub
		boolean isExist = false;
		User user = repository.getUserByMobileNumberandId(mobileNo, id);
		if(user != null) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

}
