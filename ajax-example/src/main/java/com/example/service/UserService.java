package com.example.service;

import org.springframework.stereotype.Service;

import com.example.form.model.User;

@Service
public class UserService implements IUserService{

	public User saveUser(User user) {
		return user;
	}

}
