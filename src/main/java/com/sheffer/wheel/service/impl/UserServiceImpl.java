package com.sheffer.wheel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheffer.wheel.dao.UserDao;
import com.sheffer.wheel.doamin.User;
import com.sheffer.wheel.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(String id) {
//		Optional<User> userOptional = userDao.findById(id);
//		if(userOptional.isPresent()) {
//			User uesr = userOptional.get();
//		}
		User user = userDao.findById(id).orElse(null);
		return user;
	}

	@Override
	public List<User> getUserListByAgeAndUserName(int age, String userName) {
		List<User> userList = userDao.findUserByAgeAndUserName(age, userName);
		return userList;
	}

}
