package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.form.model.User;

@Controller
public class UserController {
	@RequestMapping("userform")
	public String getPage() {
		return "userInfo";
	}
	
	@Autowired
	com.example.service.IUserService iUserService;
	
	@RequestMapping(value="addUser",method = RequestMethod.POST)
	public @ResponseBody
	User add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		User user = new User();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		return user;
	}
	
	@RequestMapping(value="addJsonUser",method = RequestMethod.POST)
	public @ResponseBody
	User addUser(@RequestBody User jsonuser)
			throws Exception {
		User user =iUserService.saveUser(jsonuser);
		return user;
	}
}
