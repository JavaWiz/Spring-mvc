package com.javawiz.service;

import org.springframework.stereotype.Service;

import com.javawiz.form.model.User;

@Service
public class UserService implements IUserService{

	public User saveUser(User user) {
		return user;
	}

}
