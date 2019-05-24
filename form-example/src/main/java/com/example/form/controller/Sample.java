package com.example.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("hi")
public class Sample {
	
	@RequestMapping(value="hello", method=RequestMethod.GET)
	public String getMessage() {
		return "Hi i am working";
	}
}
