package com.sheffer.wheel.service;

import java.util.List;

import com.sheffer.wheel.doamin.User;

public interface UserService {
	User getUserById(String id);
	List<User> getUserListByAgeAndUserName(int age, String userName);
}
