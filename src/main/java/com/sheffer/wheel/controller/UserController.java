package com.sheffer.wheel.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sheffer.wheel.Utils.JsonUtils;
import com.sheffer.wheel.doamin.User;
import com.sheffer.wheel.service.UserService;

@RestController
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public JSONObject getUserById(@RequestParam String id) {
		User user = userService.getUserById(id);
		JSONObject jsonObject = new JSONObject();
		if (user != null) {
			logger.info("User toString: " + user.toString());
			jsonObject.put("id", id);
			jsonObject.put("userName", user.getUserName());
			jsonObject.put("age", user.getAge());
		} else {
			logger.info("User id is not exist");
		}
		return jsonObject;
	}
	
	@RequestMapping(value = "/getUserListByAgeAndName", method = RequestMethod.GET)
	public JSONObject getUserListByAgeAndName(@RequestParam int age, @RequestParam String userName) {
		List<User> userList = userService.getUserListByAgeAndUserName(age, userName);
		JSONObject jsonObject = new JSONObject();
		if (!userList.isEmpty()) {
			logger.info("UserList toString: " + userList.toString());
			List<String> idList = new ArrayList<>();
			List<String> ageList = new ArrayList<>();
			for(int i=0;i<userList.size();i++){
				idList.add(userList.get(i).getId());
				ageList.add(String.valueOf(userList.get(i).getAge()));
			}
			jsonObject = JsonUtils.getJsonObject(idList, ageList);
		} else {
			logger.info("User who's age and userName is not exist");
		}
		return jsonObject;
	}

}
