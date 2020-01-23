package com.javawiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javawiz.model.DummyDB;
import com.javawiz.model.Tag;
import com.javawiz.model.User;

@Controller
public class AutoSearchController {
	
	@RequestMapping("auto_search")
	public String getPage() {
		return "home";
	}

	@RequestMapping("first")
	public String getFirstSearchPage() {
		return "first_search";
	}

	@RequestMapping("second")
	public ModelAndView getSecondSearchPage() {
		User userForm = new User();

		return new ModelAndView("second_search", "userForm",
				userForm);
	}

	@Autowired
	DummyDB dummyDB;

	@RequestMapping(value = "getTags", method = RequestMethod.GET)
	@ResponseBody
	public List<Tag> getTags(@RequestParam String tagName) {

		return dummyDB.simulateSearchResult(tagName);

	}

	@RequestMapping(value = "get_country_list", method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseBody
	public List<String> getCountryList(@RequestParam("term") String query) {
		List<String> countryList = dummyDB.getCountryList(query);

		return countryList;
	}

	@RequestMapping(value = "get_tech_list", method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseBody
	public List<String> getTechList(@RequestParam("term") String query) {
		List<String> techList = dummyDB.getTechList(query);

		return techList;
	}

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("userForm") User user) {
		System.out.println(user.getName());

		return new ModelAndView("save_user", "user", user);
	}
}
