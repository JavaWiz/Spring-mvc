package com.example.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class AutoSelectController {
	
	@RequestMapping("autoSelect")
	public String getPage(Model model){
		String[] array = {"United States","India","United Kingdom","South Africa"};
		List<String> list = Arrays.asList(array);
		model.addAttribute("countries", list);
		return "autoSelect";
	}
	
	@RequestMapping(value = "states")
	@ResponseBody
	public List<String> getStates(@RequestParam(value = "country") String country) {
		System.out.println("finding cities for state " + country);
		
		List<String> states = getState(country);
		return states;
	}
	
	private static List<String> getState(String country){
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String[] india = {"Odisha","Bihar"};
		String[] us = {"New York","New Jersey"};
		String[] uk = {"England","London"};
		String[] sa = {"Eastern Cape","Northern Cape"};
		
		map.put("India", Arrays.asList(india));
		map.put("United States", Arrays.asList(us));
		map.put("United Kingdom", Arrays.asList(uk));
		map.put("South Africa", Arrays.asList(sa));
		
		List<String> states = null;
		for (Map.Entry<String, List<String>> entry: map.entrySet()) {
			if(entry.getKey().equals(country)){
				states = entry.getValue();
				break;
			}
		}
		return states;
	}
}
